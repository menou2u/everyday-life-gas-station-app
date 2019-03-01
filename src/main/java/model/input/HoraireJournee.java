package model.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import service.deserializers.PeriodeDeserializer;

import java.util.Collection;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HoraireJournee {

    @JsonProperty("horaire")
    @JsonDeserialize(using = PeriodeDeserializer.class)
    private Collection<Periode> periodes;

    @JsonProperty("ferme")
    private String ferme;

    @JsonProperty("nom")
    private String jour;
}
