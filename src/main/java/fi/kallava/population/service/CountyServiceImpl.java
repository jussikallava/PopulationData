package fi.kallava.population.service;

import fi.kallava.population.domain.CountyEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class CountyServiceImpl extends GenericService<CountyEntity> implements CountyService {

    @Override
    Class<CountyEntity> getEntityType() {
        return CountyEntity.class;
    }

    public CountyEntity getEntityByCountyNo(int countyNo) {
        String query = "MATCH(n:CountyEntity) WHERE n.countyNo={countyNo} RETURN n";
        Map<String, Object> params = new HashMap<>();
        params.put("countyNo", countyNo);
        try {
            return session.queryForObject(CountyEntity.class, query, params);
        } catch (Exception e) {
            throw e;
        }
    }
}