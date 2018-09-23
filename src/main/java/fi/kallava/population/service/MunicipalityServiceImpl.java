package fi.kallava.population.service;

import fi.kallava.population.domain.MunicipalityEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MunicipalityServiceImpl extends GenericService<MunicipalityEntity> implements MunicipalityService {

    @Override
    Class<MunicipalityEntity> getEntityType() {
        return MunicipalityEntity.class;
    }

    public MunicipalityEntity getEntityByMunicipalityNo(int municipalityNo) {
        String query = "MATCH(n:MunicipalityEntity) WHERE n.municipalityNo={municipalityNo} RETURN n";
        Map<String, Object> params = new HashMap<>();
        params.put("municipalityNo", municipalityNo);
        try {
            return session.queryForObject(MunicipalityEntity.class, query, params);
        } catch (Exception e) {
            throw e;
        }
    }
}