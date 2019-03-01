package model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Periode {

    @JsonProperty("ouverture")
    private String ouverture;

    @JsonProperty("fermeture")
    private String fermeture;
}
