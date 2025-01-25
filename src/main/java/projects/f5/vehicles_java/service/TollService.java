package projects.f5.vehicles_java.service;

import projects.f5.vehicles_java.models.Vehicle;

class TollService {
    private TollStation tollStation;

    public TollService(TollStation tollStation) {
        this.tollStation = tollStation;
    }

    public void processVehicle(Vehicle vehicle) {
        tollStation.registerVehicle(vehicle);
    }

    public int getTotalCollected() {
        return tollStation.getTotal();
    }
}
