package service.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import model.input.Price;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PriceJsonTagDeserializer extends JsonDeserializer<List<Price>> {

    private static final String VALEUR = "valeur";
    private static final String NOM = "nom";

    @Override
    public List<Price> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        List<Price> prices = new ArrayList<>();

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<JsonNode> prixNodes = node.elements();

        while (prixNodes.hasNext()) {
            JsonNode prixNode = prixNodes.next();
            if (prixNode.get(VALEUR) != null) {
                prices.add(new Price(prixNode.get(VALEUR).asDouble(), prixNode.get(NOM).asText()));
            } else {
                double valeur = prixNode.asDouble();
                prixNodes.next();
                prixNodes.next();
                String nom = prixNodes.next().asText();
                prices.add(new Price(valeur, nom));
            }
        }
        return prices;
    }
}
