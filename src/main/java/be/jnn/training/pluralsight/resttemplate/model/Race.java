package be.jnn.training.pluralsight.resttemplate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Race {

    public Race(String raceId, String city) {
        this.raceId = raceId;
        this.city = city;
    }

    @Id
    private String raceId;

    private String city;


    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
