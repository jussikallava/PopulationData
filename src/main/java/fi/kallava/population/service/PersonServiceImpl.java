package fi.kallava.population.service;

import fi.kallava.population.domain.PersonEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends GenericService<PersonEntity> implements PersonService {

    @Override
    Class<PersonEntity> getEntityType() {
        return PersonEntity.class;
    }
}