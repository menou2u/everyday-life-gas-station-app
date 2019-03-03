package service.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import model.input.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServiceJsonTagDeserializer extends JsonDeserializer<Service> {

    private static final String SERVICE = "service";

    @Override
    public Service deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        if (node.get(SERVICE) == null) {
            return null;
        }
        List<JsonNode> services = node.findValues(SERVICE);
        JsonNode jsonNode = services.get(0);
        Iterator<JsonNode> elements = jsonNode.elements();
        List<String> allServices = new ArrayList<>();
        while (elements.hasNext()) {
            allServices.add(elements.next().textValue());
        }
        return new Service(allServices);
    }
}
