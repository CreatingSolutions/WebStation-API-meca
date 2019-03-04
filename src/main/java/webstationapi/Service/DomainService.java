package webstationapi.Service;

import org.springframework.stereotype.Service;
import webstationapi.Repository.DomainRepository;

@Service
public class DomainService {

    private DomainRepository domainRepository;

    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }
}
