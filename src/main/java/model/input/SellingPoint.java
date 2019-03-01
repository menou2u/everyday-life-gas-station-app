package model.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import service.deserializers.PrixDeserializer;
import service.deserializers.ServiceDeserializer;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SellingPoint {

    @JsonProperty("pop")
    private String pop;

    @JsonProperty("ville")
    private String ville;

    @JsonProperty("horaires")
    private Horaires horaires;

    @JsonProperty("prix")
    @JsonDeserialize(using = PrixDeserializer.class)
    private Prix[] allPrix;

    @JsonProperty("latitude")
    private Number latitude;

    @JsonProperty("longitude")
    private Number longitude;

    @JsonProperty(value = "services")
    @JsonDeserialize(using = ServiceDeserializer.class)
    private Service services;

}
