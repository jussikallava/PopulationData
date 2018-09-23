package fi.kallava.population.service;

import fi.kallava.population.domain.CountyEntity;

interface CountyService extends Service<CountyEntity> {
    CountyEntity getEntityByCountyNo(int countyNo);
}