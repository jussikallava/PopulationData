package fi.kallava.population.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person extends Entity {

    @Relationship("HAS_FIRSTNAME")
    private FirstName firstName;

    @Relationship("HAS_LASTNAME")
    private LastName lastname;

    private String ssid;

    public Person(){}

    public Person(FirstName firstName, LastName lastname, String ssid){
        setName(firstName);
        setLastName(lastname);
        setSsid(ssid);
    }

    public FirstName getName() {
        return firstName;
    }

    public void setLastName(LastName lastname) {
        this.lastname = lastname;
    }

    public LastName getLastName() {
        return lastname;
    }

    public void setName(FirstName firstName) {
        this.firstName = firstName;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getSsid() {
        return ssid;
    }

}
