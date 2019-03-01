package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Carburant {

    @JsonProperty("nom")
    private CarburantNameEnum carburantName;

    @JsonProperty("valeur")
    private Double price;

    public enum CarburantNameEnum {
        GAZOLE, E85, E10, SP98;
    }

}
