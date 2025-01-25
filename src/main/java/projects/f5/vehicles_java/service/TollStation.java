package projects.f5.vehicles_java.service;

import java.util.List;
import java.util.ArrayList;

import projects.f5.vehicles_java.models.Vehicle;

public class TollStation {
    private String name;
    private String city;
    private int totalCollected;
    private List<Vehicle> vehicles;

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.totalCollected = 0;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getTotalCollected() {
        return totalCollected;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void registerVehicle(Vehicle vehicle) {
        int toll = vehicle.calculateToll();
        totalCollected += toll;
        vehicles.add(vehicle);
    }

    public int getTotal() {
        return totalCollected;
    }

    public void listVehicles() {
        System.out.println("Vehicles registered at " + name + ":");
        for (Vehicle v : vehicles) {
            System.out.println("- " + v.getRegistrationPlate() + " | Toll: $" + v.calculateToll());
        }
        System.out.println("Total collected: $" + totalCollected);
    }
}
