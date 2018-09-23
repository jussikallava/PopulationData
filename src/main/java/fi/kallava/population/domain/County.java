package fi.kallava.population.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class County extends Entity {

    @NotBlank(message = "Name for the county is required!")
    private String name;
    private String namesv;
    @NotBlank(message = "Number for the county is required!")
    private int countyNo;

    public County(){}

    public County(String name, String namesv, int countyNo){
        setCountyNo(countyNo);
        setName(name);
        setNameSv(namesv);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSv() {
        return namesv;
    }

    public void setNameSv(String namesv) {
        this.namesv = namesv;
    }

    public int getCountyNo() {
        return countyNo;
    }

    public void setCountyNo(int countyNo) {
        this.countyNo = countyNo;
    }

}
