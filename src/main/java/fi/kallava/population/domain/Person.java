package fi.kallava.population.domain;

import org.hibernate.validator.constraints.NotBlank;

public class PersonRequest {

    @NotBlank(message = "ID for the firstname is required!")
    private String firstname;
    @NotBlank(message = "ID for the lastname is required!")
    private String lastname;
    @NotBlank(message = "Social security ID must be provided!")
    private String ssid;

    public PersonRequest() {
    }

    public PersonRequest(String firstname, String lastname, String ssid) {
        setFirstname(firstname);
        setLastname(lastname);
        setSsid(ssid);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getSsid() {
        return ssid;
    }

}
