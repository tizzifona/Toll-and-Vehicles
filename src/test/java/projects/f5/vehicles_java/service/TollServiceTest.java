package projects.f5.vehicles_java.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import projects.f5.vehicles_java.models.Car;
import projects.f5.vehicles_java.models.Motorbike;
import projects.f5.vehicles_java.models.Truck;

public class TollServiceTest {

    private TollStation tollStation;
    private TollService tollService;

    @BeforeEach
    void setUp() {
        tollStation = new TollStation("Main Toll", "CityName");
        tollService = new TollService(tollStation);
    }

    @Test
    void testGetTotalCollected() {
        assertThat(tollService.getTotalCollected(), is(0));

        tollService.processVehicle(new Car("ABC123"));
        tollService.processVehicle(new Motorbike("XYZ456"));
        tollService.processVehicle(new Truck("DEF789", 3));

        int expectedTotal = 100 + 50 + 150;
        assertThat(tollService.getTotalCollected(), is(expectedTotal));
    }

    @Test
    void testProcessVehicle() {
        assertThat(tollStation.getVehicles(), is(empty()));

        Car car = new Car("ABC123");
        tollService.processVehicle(car);

        assertThat(tollStation.getVehicles(), hasSize(1));
        assertThat(tollStation.getVehicles(), contains(car));

        assertThat(tollService.getTotalCollected(), is(100));
    }

    @Test
    void testProcessMultipleVehicles() {
        Car car = new Car("ABC123");
        Motorbike motorbike = new Motorbike("XYZ456");
        Truck truck = new Truck("DEF789", 3);

        tollService.processVehicle(car);
        tollService.processVehicle(motorbike);
        tollService.processVehicle(truck);

        assertThat(tollStation.getVehicles(), contains(car, motorbike, truck));
        int expectedTotal = 100 + 50 + 150;
        assertThat(tollService.getTotalCollected(), is(expectedTotal));
    }
}
