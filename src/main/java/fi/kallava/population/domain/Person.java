package fi.kallava.population.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person extends Entity {

    @Relationship("IS_NAMED")
    private FirstName firstName;

    private String ssid;
    private int count;

    public Person(){}

    public Person(FirstName firstName, String ssid, Integer count){
        setCount(count);
        setName(firstName);
        setSsid(ssid);
    }

    public FirstName getName() {
        return firstName;
    }

    public void setName(FirstName firstName) {
        this.firstName = firstName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count.intValue();
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getSsid() {
        return ssid;
    }

}
