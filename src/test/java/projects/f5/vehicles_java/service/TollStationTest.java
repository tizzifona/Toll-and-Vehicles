package projects.f5.vehicles_java.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.f5.vehicles_java.models.Car;
import projects.f5.vehicles_java.models.Motorbike;
import projects.f5.vehicles_java.models.Truck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TollStationTest {

    private TollStation tollStation;
    private Car car;
    private Motorbike motorbike;
    private Truck truck;

    @BeforeEach
    void setUp() {
        tollStation = new TollStation("Central Station", "New York");
        car = new Car("ABC123");
        motorbike = new Motorbike("XYZ789");
        truck = new Truck("DEF456", 4);
    }

    @Test
    void testGetCity() {
        assertThat(tollStation.getCity(), is("New York"));
    }

    @Test
    void testGetName() {
        assertThat(tollStation.getName(), is("Central Station"));
    }

    @Test
    void testGetTotal() {
        tollStation.registerVehicle(car);
        tollStation.registerVehicle(motorbike);
        assertThat(tollStation.getTotal(), is(150));
    }

    @Test
    void testGetTotalCollected() {
        tollStation.registerVehicle(car);
        tollStation.registerVehicle(motorbike);
        assertThat(tollStation.getTotalCollected(), is(150));
    }

    @Test
    void testGetVehicles() {
        tollStation.registerVehicle(car);
        tollStation.registerVehicle(motorbike);
        assertThat(tollStation.getVehicles(), containsInAnyOrder(car, motorbike));
    }

    @Test
    void testListVehicles() {
        tollStation.registerVehicle(car);
        tollStation.registerVehicle(motorbike);
        tollStation.registerVehicle(truck);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        tollStation.listVehicles();

        System.setOut(originalSystemOut);

        String output = outputStream.toString();
        assertThat(output, containsString("Vehicles registered at Central Station:"));
        assertThat(output, containsString("- ABC123 | Toll: $100"));
        assertThat(output, containsString("- XYZ789 | Toll: $50"));
        assertThat(output, containsString("- DEF456 | Toll: $200"));
        assertThat(output, containsString("Total collected: $350"));
    }

    @Test
    void testRegisterVehicle() {
        tollStation.registerVehicle(car);
        tollStation.registerVehicle(truck);

        assertThat(tollStation.getTotalCollected(), is(300));
        assertThat(tollStation.getVehicles(), hasSize(2));
        assertThat(tollStation.getVehicles(), containsInAnyOrder(car, truck));
    }

}
