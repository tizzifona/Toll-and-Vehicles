package projects.f5.vehicles_java.models;

class Motorbike extends Vehicle {

    public Motorbike(String registrationPlate) {
        super(registrationPlate);
    }

    @Override
    public int calculateToll() {
        return 50;
    }
}
