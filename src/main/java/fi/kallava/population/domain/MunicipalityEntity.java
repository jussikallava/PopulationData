package fi.kallava.population.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class MunicipalityEntity extends Entity {

    @Relationship("BELONGS_TO")
    private CountyEntity county;

    private String name;
    private int municipalityNo;

    public MunicipalityEntity(){}

    public MunicipalityEntity(String name, CountyEntity county, int municipalityNo){
        setCounty(county);
        setMunicipalityNo(municipalityNo);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMunicipalityNo() {
        return municipalityNo;
    }

    public void setMunicipalityNo(int municipalityNo) {
        this.municipalityNo = municipalityNo;
    }

    public void setCounty(CountyEntity county) {
        this.county = county;
    }

    public CountyEntity getCounty() {
        return county;
    }

}
