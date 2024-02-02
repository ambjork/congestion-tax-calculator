package com.example.myspringbootapp.app.service;

import com.example.myspringbootapp.app.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CalculationServiceTest {

    @Autowired
    CalculationService service;

    @Test
    void contextLoads() throws Exception {
        assertThat(service).isNotNull();
    }

    @Test
    void vehiclesThatShouldBeCharged() {
        // CAR
        Car car = createCar();

        Integer carTaxSum = service.getTax(car);

        Assertions.assertEquals(1, carTaxSum);

        // MOTORBIKE
        Motorbike motorbike = new Motorbike();
        setPassageTime(motorbike);

        Integer motorbikeTaxSum = service.getTax(motorbike);

        Assertions.assertEquals(1, motorbikeTaxSum);
    }

    @Test
    void vehiclesThatShouldNotBeCharged() {
        // BUS
        Bus bus = new Bus();
        setPassageTime(bus);
        Integer busTaxSum = service.getTax(bus);
        Assertions.assertEquals(0, busTaxSum);

        // DIPLOMAT VEHICLE
        DiplomatVehicle diplomatVehicle = new DiplomatVehicle();
        setPassageTime(diplomatVehicle);
        Integer diplomatVTaxSum = service.getTax(diplomatVehicle);
        Assertions.assertEquals(0, diplomatVTaxSum);

        // EMERGENCY VEHICLE
        EmergencyVehicle emergencyVehicle = new EmergencyVehicle();
        setPassageTime(emergencyVehicle);
        Integer EmergVTaxSum = service.getTax(emergencyVehicle);
        Assertions.assertEquals(0, EmergVTaxSum);

        // FOREIGN VEHICLE
        ForeignVehicle foreignVehicle = new ForeignVehicle();
        setPassageTime(foreignVehicle);
        Integer foreignVTaxSum = service.getTax(foreignVehicle);
        Assertions.assertEquals(0, foreignVTaxSum);

        // MILITARY VEHICLE
        MilitaryVehicle militaryVehicle = new MilitaryVehicle();
        setPassageTime(militaryVehicle);
        Integer militrVTaxSum = service.getTax(militaryVehicle);
        Assertions.assertEquals(0, militrVTaxSum);

    }

    private Car createCar() {
        Car car = new Car();
        car.setRegNum("ABC123");
        setPassageTime(car);

        return car;
    }

    private void setPassageTime(AbstractVehicle vehicle) {
        vehicle.addPassageTime(toLocalDateTime("2013-01-14 21:00:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-01-15 21:00:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-07 06:23:27"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-07 15:27:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 06:20:27"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 14:35:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 15:29:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 15:47:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 16:01:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 16:01:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 16:48:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 17:49:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 18:29:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-08 18:35:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-03-26 14:25:00"));
        vehicle.addPassageTime(toLocalDateTime("2013-03-28 14:07:27"));
    }

    private LocalDateTime toLocalDateTime(String dateTimeStr) {
        dateTimeStr = dateTimeStr.replaceAll(" ", "T");
        return LocalDateTime.parse(dateTimeStr);
    }
}
