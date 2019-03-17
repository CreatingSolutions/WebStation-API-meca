package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.Lift;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;

import java.util.List;

public interface LiftRepository extends JpaRepository<Lift, Long> {

    public List<Lift> findByTypeAndAgeAndDiamondIsFalse(TypeEnum type, AgeEnum age);

    public List<Lift> findByTypeAndAgeAndDiamondIsTrue(TypeEnum type, AgeEnum age);

    List<Lift> findByType(TypeEnum typeEnum);

}
