package fi.kallava.population.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Municipality extends Entity {

    @NotBlank(message = "Name for the municipality is required!")
    private String name;
    private String nameSv;
    private String countyName;
    @NotBlank(message = "Number for the municipality is required!")
    private int municipalityNo;
    @NotBlank(message = "Number for the county is required!")
    private int countyNo;

    public Municipality(){}

    public Municipality(String name, String nameSv, String countyName, int municipalityNo, int countyNo){
        setMunicipalityNo(municipalityNo);
        setCountyNo(countyNo);
        setName(name);
        setNameSv(nameSv);
        setCountyName(countyName);
    }

    public String getName() {
        return name;
    }

    public void setName(String nameSv) {
        this.name = nameSv;
    }

    public String getNameSv() {
        return nameSv;
    }

    public void setNameSv(String nameSv) {
        this.nameSv = nameSv;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCountyNo() {
        return countyNo;
    }

    public void setCountyNo(int countyNo) {
        this.countyNo = countyNo;
    }

    public int getMunicipalityNo() {
        return municipalityNo;
    }

    public void setMunicipalityNo(int municipalityNo) {
        this.municipalityNo = municipalityNo;
    }

}
