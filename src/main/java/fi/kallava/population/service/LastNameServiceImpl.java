package fi.kallava.population.service;

import fi.kallava.population.domain.LastNameEntity;
import org.springframework.stereotype.Service;

@Service
public class LastNameServiceImpl extends GenericService<LastNameEntity> implements LastNameService {

    @Override
    Class<LastNameEntity> getEntityType() {
        return LastNameEntity.class;
    }
}