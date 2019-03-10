package webstationapi.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.DTO.TelesiegeDTO;
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

    @Transactional(readOnly = true)
    public Telesiege findById(Long id) {
        return this.telesiegeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Telesiege not found for id " + id));
    }

    @Transactional(readOnly = true)
    public List<Telesiege> findAll() {
        return this.findAll();
    }

    @Transactional(readOnly = true)
    public Double getPrice(List<TelesiegeDTO> telesieges) {
        Double basePrice = 0.0;

        for (TelesiegeDTO dto : telesieges) {
            Telesiege telesiege = this.findById(dto.getId());
            basePrice += telesiege.getPrice() * dto.getNbFois();
        }
        return basePrice;
    }
}
