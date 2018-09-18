package fi.kallava.population.service;

import fi.kallava.population.domain.Municipality;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityServiceImpl extends GenericService<Municipality> implements MunicipalityService {

    @Override
    Class<Municipality> getEntityType() {
        return Municipality.class;
    }
}