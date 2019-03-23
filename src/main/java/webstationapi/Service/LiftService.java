package webstationapi.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.DTO.ForfaitDTO;
import webstationapi.DTO.LiftBookDTO;
import webstationapi.DTO.LiftDTO;
import webstationapi.Entity.Lift;
import webstationapi.Entity.LiftBooking;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;
import webstationapi.Repository.LiftBookingRepository;
import webstationapi.Repository.LiftRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LiftService {

    private LiftRepository liftRepository;

    private LiftBookingRepository liftBookingRepository;

    public LiftService(LiftRepository liftRepository, LiftBookingRepository liftBookingRepository) {
        this.liftRepository = liftRepository;
        this.liftBookingRepository = liftBookingRepository;
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
            forfaitDTO.setPrices(lift.getPrice());
            forfaitDTOS.add(forfaitDTO);
        }

        return forfaitDTOS;
    }

    public List<Lift> findtelesiege(TypeEnum type) {
        return this.liftRepository.findByType(type);
    }


    public Long addcart(LiftBookDTO liftBookDTO) {

        Lift byId = liftRepository.findById(liftBookDTO.getLiftId()).get();
        
        LiftBooking liftBooking = new LiftBooking();
        liftBooking.setUserId(liftBookDTO.getUserId());
        if (liftBookDTO.isInsurance())
            liftBooking.setPrice(byId.getPrice() * liftBookDTO.getTaked() + byId.getInsurrance());
        else
            liftBooking.setPrice(byId.getPrice() * liftBookDTO.getTaked());

        liftBooking.setLiftId(liftBookDTO.getLiftId());
        liftBooking.setInsurance(liftBookDTO.isInsurance());

        LiftBooking save = this.liftBookingRepository.save(liftBooking);
        return save.getLiftId();
    }
}
