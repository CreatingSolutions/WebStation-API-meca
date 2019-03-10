package webstationapi.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.DTO.LiftPriceDTO;
import webstationapi.Entity.Lift;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;
import webstationapi.Repository.LiftRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LiftService {

    private LiftRepository liftRepository;

    public LiftService(LiftRepository liftRepository) {
        this.liftRepository = liftRepository;
    }

    @Transactional(readOnly = true)
    public Lift findById(Long id) {
        return this.liftRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Lift not found for id : " + id));
    }

    @Transactional(readOnly = true)
    public List<Lift> findByTypeAndAge(TypeEnum type, AgeEnum age) {
        return this.liftRepository.findByTypeAndAge(type, age);
    }

    public Double calculePrice(List<LiftPriceDTO> liftPriceDTOS) {
        Double basePrice = 0.0;

        for (LiftPriceDTO liftPrice : liftPriceDTOS) {
            Lift lift = this.findById(liftPrice.getId());
            Double priceTmp;
            if (liftPrice.isDiamond()) {
                priceTmp = lift.getPrice_diamond() * liftPrice.getNbFois();
            } else {
                priceTmp = lift.getPrice() * liftPrice.getNbFois();
            }

            if (liftPrice.isInsurrance()) {
                priceTmp += liftPrice.getNbFois() * lift.getInsurrance();
            }
            basePrice += priceTmp;
        }

        return basePrice;
    }
}
