package fi.kallava.population.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Occupation extends Entity {

    @NotBlank(message = "Name for the occupation is required!")
    private String name;
    @NotBlank(message = "Number for the occupation is required!")
    private int occupationNo;

    public Occupation(){}

    public Occupation(String name, int occupationNo){
        setOccupationNo(occupationNo);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccupationNo() {
        return occupationNo;
    }

    public void setOccupationNo(int occupationNo) {
        this.occupationNo = occupationNo;
    }

}
