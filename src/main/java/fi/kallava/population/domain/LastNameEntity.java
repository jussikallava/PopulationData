package fi.kallava.population.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class LastNameEntity extends Entity {

    private String name;
    private int count;

    public LastNameEntity(){}

    public LastNameEntity(String name, Integer count){
        setCount(count);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count.intValue();
    }
}
