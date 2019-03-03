package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Fuel {

    @JsonProperty("nom")
    private FuelNameEnum fuelName;

    @JsonProperty("valeur")
    private Double price;

    public enum FuelNameEnum {
        GAZOLE, E85, E10, SP98;
    }

}
