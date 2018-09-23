package fi.kallava.population.service;

import fi.kallava.population.domain.MunicipalityEntity;

interface MunicipalityService extends Service<MunicipalityEntity> {
    MunicipalityEntity getEntityByMunicipalityNo(int municipalityNo);
}