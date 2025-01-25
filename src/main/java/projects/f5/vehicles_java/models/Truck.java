package projects.f5.vehicles_java.models;

public class Truck extends Vehicle {

    private int axles;

    public Truck(String registrationPlate, int axles) {
        super(registrationPlate);
        this.axles = axles;
    }

    @Override
    public int calculateToll() {
        return 50 * axles;
    }
}
