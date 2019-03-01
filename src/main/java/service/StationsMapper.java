package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import model.Station;
import model.input.JsonResponse;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class StationsMapper {

    public List<Station> getAllStations(JSONObject jsonObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonResponse map = new JsonResponse();
        try {
            map = objectMapper.readValue(new File("C:\\Users\\t553678\\Downloads\\output.json"), JsonResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Station> allStations = new ArrayList<>();

        return allStations;
    }
}
