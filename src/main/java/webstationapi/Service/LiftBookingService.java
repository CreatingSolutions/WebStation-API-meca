package webstationapi.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstationapi.DTO.LiftDTO;
import webstationapi.Entity.LiftBooking;
import webstationapi.Repository.LiftBookingRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class LiftBookingService {

    private LiftBookingRepository liftBookingRepository;

    @Autowired
    private LiftService liftService;

    public LiftBookingService(LiftBookingRepository liftBookingRepository) {
        this.liftBookingRepository = liftBookingRepository;
    }

    public List<LiftBooking> getAllBookByUser(Long id) {
        return this.liftBookingRepository.findAllByIdUser(id);
    }

    public void makeBook(List<LiftDTO> liftDTOS, Long idUser) {

        for (LiftDTO liftDTO : liftDTOS) {
            LiftBooking liftBooking = new LiftBooking();
            liftBooking.setDiamond(liftDTO.isDiamond());
            liftBooking.setIdLift(liftDTO.getId());
            liftBooking.setIdUser(idUser);
            liftBooking.setInsurrance(liftDTO.isInsurrance());
            liftBooking.setNbFois(liftDTO.getNbFois());
            liftBooking.setValid(false);
            liftBooking.setPrice(this.liftService.calculePrice(Arrays.asList(liftDTO)));
            this.liftBookingRepository.save(liftBooking);
        }

    }
}
