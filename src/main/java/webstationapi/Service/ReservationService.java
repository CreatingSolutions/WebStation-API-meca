package webstationapi.Service;

import org.springframework.stereotype.Service;
import webstationapi.Repository.ReservationRepository;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;


    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
}
