package webstationapi.Service;

import org.springframework.stereotype.Service;
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

    public Lift findById(Long id) {
        return this.liftRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Lift not found for id : " + id));
    }

    public List<Lift> findByTypeAndAge(TypeEnum type, AgeEnum age) {
        return this.liftRepository.findByTypeAndAge(type, age);
    }
}
