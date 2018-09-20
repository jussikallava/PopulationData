package fi.kallava.population.domain;

import org.hibernate.validator.constraints.NotBlank;

public class PersonRequest {

    @NotBlank(message = "ID for the name is required!")
    private String testi;
    @NotBlank(message = "Social security ID must be provided!")
    private String ssid;

    public PersonRequest() {
    }

    public PersonRequest(String testi, String ssid) {
        setTesti(testi);
        setSsid(ssid);
    }

    public String getTesti() {
        return testi;
    }

    public void setTesti(String testi) {
        this.testi = testi;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getSsid() {
        return ssid;
    }

}
