package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.Lift;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;

import java.util.List;

public interface LiftRepository extends JpaRepository<Lift, Long> {

    public List<Lift> findByTypeAndAge(TypeEnum type, AgeEnum age);

}
