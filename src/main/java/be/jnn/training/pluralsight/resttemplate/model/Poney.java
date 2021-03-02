package be.jnn.training.pluralsight.resttemplate.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("poney")
public class Poney {
        private String poneyId;
        private String poneyName;

    public String getPoneyId() {
        return poneyId;
    }

    public void setPoneyId(String poneyId) {
        this.poneyId = poneyId;
    }

    public String getPoneyName() {
        return poneyName;
    }

    public void setPoneyName(String poneyName) {
        this.poneyName = poneyName;
    }
}
