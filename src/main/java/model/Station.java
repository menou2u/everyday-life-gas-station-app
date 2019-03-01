package model;

import lombok.Data;
import model.input.Service;

import java.util.List;

@Data
public class Station {

    private Position position;

    private List<Carburant> availableCarburants;

    private List<Service> availableServices;
}
