package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.Lift;

public interface LiftRepository extends JpaRepository<Lift, Long> {
}
