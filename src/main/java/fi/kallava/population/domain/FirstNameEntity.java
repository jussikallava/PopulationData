package fi.kallava.population.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class FirstName extends Entity {

    private String name;
    private String sex;
    private int count;

    public FirstName(){}

    public FirstName(String name, String sex, Integer count){
        setCount(count);
        setName(name);
        setSex(sex);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
