package fi.kallava.population.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;

@NodeEntity
public class PersonEntity extends Entity {

    @Relationship("HAS_FIRSTNAME")
    private FirstNameEntity firstName;

    @Relationship("HAS_LASTNAME")
    private LastNameEntity lastname;

    @Relationship("LIVES_IN")
    private MunicipalityEntity municipality;

    private String ssid;

    private Date dateOfBirth;

    public PersonEntity(){}

    public PersonEntity(FirstNameEntity firstName, LastNameEntity lastname, MunicipalityEntity municipality, String ssid, Date dateOfBirth){
        setName(firstName);
        setLastName(lastname);
        setMunicipality(municipality);
        setSsid(ssid);
        setDateOfBirth(dateOfBirth);
    }

    public FirstNameEntity getName() {
        return firstName;
    }

    public void setName(FirstNameEntity firstName) {
        this.firstName = firstName;
    }

    public void setLastName(LastNameEntity lastname) {
        this.lastname = lastname;
    }

    public LastNameEntity getLastName() {
        return lastname;
    }

    public void setMunicipality(MunicipalityEntity municipality) {
        this.municipality = municipality;
    }

    public MunicipalityEntity getMunicipality() {
        return municipality;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getSsid() {
        return ssid;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

}
