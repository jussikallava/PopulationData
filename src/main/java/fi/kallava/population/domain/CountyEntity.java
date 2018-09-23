package fi.kallava.population.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class CountyEntity extends Entity {

    private String name;

    private int countyNo;

    public CountyEntity(){}

    public CountyEntity(String name, int countyNo){
        setCountyNo(countyNo);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountyNo() {
        return countyNo;
    }

    public void setCountyNo(int countyNo) {
        this.countyNo = countyNo;
    }

}
