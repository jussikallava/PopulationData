package fi.kallava.population.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Municipality extends Entity {

    private String name;
    private int municipalityNo;

    public Municipality(){}

    public Municipality(String name, Integer municipalityNo){
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

    public void setMunicipalityNo(Integer municipalityNo) {
        this.municipalityNo = municipalityNo.intValue();
    }

}
