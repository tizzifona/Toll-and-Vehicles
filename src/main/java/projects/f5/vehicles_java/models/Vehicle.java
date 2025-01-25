package projects.f5.vehicles_java.models;

abstract class Vehicle {
    protected String registrationPlate;

    public Vehicle(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public abstract int calculateToll();
}
