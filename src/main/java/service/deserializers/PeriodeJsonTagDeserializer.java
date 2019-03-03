package service.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import model.input.Period;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PeriodeJsonTagDeserializer extends JsonDeserializer<Collection<Period>> {

    private static final String OUVERTURE = "ouverture";
    private static final String FERMETURE = "fermeture";

    @Override
    public Collection<Period> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Collection<Period> periodes = new ArrayList<>();

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<JsonNode> horairesNodes = node.elements();
        while (horairesNodes.hasNext()) {
            JsonNode horaire = horairesNodes.next();
            if (horaire.get(OUVERTURE) != null) {
                periodes.add(new Period(horaire.get(OUVERTURE).asText(), horaire.get(FERMETURE).asText()));
            } else {
                String ferm = horaire.asText();
                String ouv = horairesNodes.next().asText();
                periodes.add(new Period(ouv, ferm));
            }

        }
        return periodes;
    }
}
