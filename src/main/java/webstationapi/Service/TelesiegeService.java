package webstationapi.Service;

import org.springframework.stereotype.Service;
import webstationapi.Entity.Telesiege;
import webstationapi.Repository.TelesiegeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TelesiegeService {

    private TelesiegeRepository telesiegeRepository;

    public TelesiegeService(TelesiegeRepository telesiegeRepository) {
        this.telesiegeRepository = telesiegeRepository;
    }

    public Telesiege findById(Long id) {
        return this.telesiegeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Telesiege not found for id " + id));
    }

    public List<Telesiege> findAll() {
        return this.findAll();
    }
}
