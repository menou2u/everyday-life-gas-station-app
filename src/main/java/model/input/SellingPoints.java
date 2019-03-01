package model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SellingPoints {

    @JsonProperty("pdv")
    private SellingPoint[] sellingPoints;
}
