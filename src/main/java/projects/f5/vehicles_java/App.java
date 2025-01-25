package projects.f5.vehicles_java;

import projects.f5.vehicles_java.models.Car;
import projects.f5.vehicles_java.models.Motorbike;
import projects.f5.vehicles_java.models.Truck;
import projects.f5.vehicles_java.models.Vehicle;
import projects.f5.vehicles_java.service.TollService;
import projects.f5.vehicles_java.service.TollStation;

public final class App {
    public static void main(String[] args) {
        TollStation station = new TollStation("Central Toll", "City A");
        TollService service = new TollService(station);

        Vehicle car1 = new Car("ABC123");
        Vehicle motorbike1 = new Motorbike("XYZ987");
        Vehicle truck1 = new Truck("DEF456", 4);

        service.processVehicle(car1);
        service.processVehicle(motorbike1);
        service.processVehicle(truck1);

        station.listVehicles();
    }
}
