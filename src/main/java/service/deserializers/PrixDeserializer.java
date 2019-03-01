package service.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import model.input.Prix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrixDeserializer extends JsonDeserializer<Prix[]> {

    private static final String VALEUR = "valeur";
    private static final String NOM = "nom";

    @Override
    public Prix[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        List<Prix> prix = new ArrayList<>();

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<JsonNode> prixNodes = node.elements();

        while (prixNodes.hasNext()) {
            JsonNode prixNode = prixNodes.next();
            if (prixNode.get(VALEUR) != null) {
                prix.add(new Prix(prixNode.get(VALEUR).asDouble(), prixNode.get(NOM).asText()));
            } else {
                double valeur = prixNode.asDouble();
                prixNodes.next();
                prixNodes.next();
                String nom = prixNodes.next().asText();
                prix.add(new Prix(valeur, nom));
            }
        }
        return prix.toArray(new Prix[prix.size()]);
    }
}
