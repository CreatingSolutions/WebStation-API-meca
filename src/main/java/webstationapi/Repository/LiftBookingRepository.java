package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.Lift;
import webstationapi.Entity.LiftBooking;

public interface LiftBookingRepository extends JpaRepository<LiftBooking, Long> {
}
