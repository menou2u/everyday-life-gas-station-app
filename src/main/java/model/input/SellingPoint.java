package model.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import service.deserializers.PriceJsonTagDeserializer;
import service.deserializers.ServiceJsonTagDeserializer;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SellingPoint {

    @JsonProperty("pop")
    private String pop;

    @JsonProperty("ville")
    private String city;

    @JsonProperty("horaires")
    private OpeningTimes openingTimes;

    @JsonProperty("prix")
    @JsonDeserialize(using = PriceJsonTagDeserializer.class)
    private List<Price> allPrices;

    @JsonProperty("latitude")
    private Number latitude;

    @JsonProperty("longitude")
    private Number longitude;

    @JsonProperty(value = "services")
    @JsonDeserialize(using = ServiceJsonTagDeserializer.class)
    private Service services;

}
