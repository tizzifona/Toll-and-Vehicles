package projects.f5.vehicles_java.models;

class Car extends Vehicle {
    public Car(String registrationPlate) {
        super(registrationPlate);
    }

    @Override
    public int calculateToll() {
        return 100;
    }
}
