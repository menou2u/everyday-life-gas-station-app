package model.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpeningTimes {

    @JsonProperty("jour")
    private DayOpeningTime[] dayOpeningTimes;
}
