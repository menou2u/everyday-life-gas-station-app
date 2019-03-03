package model.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import service.deserializers.PeriodeJsonTagDeserializer;

import java.util.Collection;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DayOpeningTime {

    @JsonProperty("horaire")
    @JsonDeserialize(using = PeriodeJsonTagDeserializer.class)
    private Collection<Period> periods;

    @JsonProperty("ferme")
    private String ferme;

    @JsonProperty("nom")
    private String day;
}
