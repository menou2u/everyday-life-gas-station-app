package model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JsonData {

    @JsonProperty("pdv_liste")
    private SellingPoints sellingsPoints;
}
