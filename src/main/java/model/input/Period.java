package model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Period {

    @JsonProperty("ouverture")
    private String opening;

    @JsonProperty("fermeture")
    private String closing;
}
