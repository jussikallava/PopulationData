package fi.kallava.population.service;

import fi.kallava.population.domain.FirstNameEntity;
import org.springframework.stereotype.Service;

@Service
public class FirstNameServiceImpl extends GenericService<FirstNameEntity> implements FirstNameService {

    @Override
    Class<FirstNameEntity> getEntityType() {
        return FirstNameEntity.class;
    }
}