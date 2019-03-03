package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import model.Station;
import model.input.JsonData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class StationsMapper {

    public List<Station> getAllStations() {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonData map = new JsonData();
        try {

            System.out.println(new java.io.File("").getAbsolutePath());
            map = objectMapper.readValue(new File("src/main/resources/output.json"), JsonData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Station> allStations = new ArrayList<>();

        return allStations;
    }
}
