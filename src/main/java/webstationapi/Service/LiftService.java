package webstationapi.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.DTO.ForfaitDTO;
import webstationapi.DTO.LiftDTO;
import webstationapi.Entity.Lift;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;
import webstationapi.Repository.LiftRepository;

import java.util.ArrayList;
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
    public List<Lift> findByTypeAndAge(TypeEnum type, AgeEnum age, boolean b) {

        if (b)
            return this.liftRepository.findByTypeAndAgeAndDiamondIsTrue(type, age);
        else
            return this.liftRepository.findByTypeAndAgeAndDiamondIsFalse(type, age);

    }

    public Double calculePrice(List<LiftDTO> liftDTOS) {
        Double basePrice = 0.0;

        return basePrice;
    }

    public List<ForfaitDTO> buildForfait(List<Lift> normal) {
        List<ForfaitDTO> forfaitDTOS = new ArrayList<>();

        for (Lift lift : normal) {
            ForfaitDTO forfaitDTO = new ForfaitDTO();
            forfaitDTO.setId(lift.getId());
            forfaitDTO.setLabel(lift.getLabel());
            forfaitDTO.setPrice(lift.getPrice());
            forfaitDTOS.add(forfaitDTO);
        }

        return forfaitDTOS;
    }

    public List<Lift> findtelesiege(TypeEnum type) {
        return this.liftRepository.findByType(type);
    }


}
