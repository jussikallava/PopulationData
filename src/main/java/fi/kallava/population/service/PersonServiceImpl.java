package fi.kallava.population.service;

import fi.kallava.population.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends GenericService<Person> implements PersonService {

    @Override
    Class<Person> getEntityType() {
        return Person.class;
    }
}