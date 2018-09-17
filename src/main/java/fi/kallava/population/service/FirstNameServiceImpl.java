package fi.kallava.population.service;

import fi.kallava.population.domain.FirstName;
import org.springframework.stereotype.Service;

@Service
public class FirstNameServiceImpl extends GenericService<FirstName> implements FirstNameService {

    @Override
    Class<FirstName> getEntityType() {
        return FirstName.class;
    }
}