package model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JsonResponse {

    @JsonProperty("pdv_liste")
    private SellingPoints sellingsPoints;
}
