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
    void itShouldChargeTotalFeeOf60SEKPerDate() {
        Car car = new Car();
        setPassageTime3Days(car);

        Integer carTaxSum = service.getTax(car);

        Assertions.assertEquals(89, carTaxSum);
    }

    @Test
    void itShouldNotChargeDuringJuly() {
        Car car = new Car();
        setPassageTimeDuringJuly(car);

        Integer carTaxSum = service.getTax(car);

        Assertions.assertEquals(0, carTaxSum);
    }

    @Test
    void itShouldChargeOncePerHour() {
        Motorbike motorbike = new Motorbike();
        setPassageTimeOneHour(motorbike);

        Integer motorbikeTaxSum = service.getTax(motorbike);

        Assertions.assertEquals(18, motorbikeTaxSum);
    }

    @Test
    void itShouldNotChargeOnPublicHoliday() {
        // or day before public holiday
        Car car = new Car();
        setPassageTimePublicHoliday(car);

        Integer carTaxSum = service.getTax(car);

        Assertions.assertEquals(18, carTaxSum);
    }


    @Test
    void vehiclesThatShouldNotBeCharged() {
        // BUS
        Bus bus = new Bus();
        setPassageTime3Days(bus);
        Integer busTaxSum = service.getTax(bus);
        Assertions.assertEquals(0, busTaxSum);

        // DIPLOMAT VEHICLE
        DiplomatVehicle diplomatVehicle = new DiplomatVehicle();
        setPassageTime3Days(diplomatVehicle);
        Integer diplomatVTaxSum = service.getTax(diplomatVehicle);
        Assertions.assertEquals(0, diplomatVTaxSum);

        // EMERGENCY VEHICLE
        EmergencyVehicle emergencyVehicle = new EmergencyVehicle();
        setPassageTime3Days(emergencyVehicle);
        Integer EmergVTaxSum = service.getTax(emergencyVehicle);
        Assertions.assertEquals(0, EmergVTaxSum);

        // FOREIGN VEHICLE
        ForeignVehicle foreignVehicle = new ForeignVehicle();
        setPassageTime3Days(foreignVehicle);
        Integer foreignVTaxSum = service.getTax(foreignVehicle);
        Assertions.assertEquals(0, foreignVTaxSum);

        // MILITARY VEHICLE
        MilitaryVehicle militaryVehicle = new MilitaryVehicle();
        setPassageTime3Days(militaryVehicle);
        Integer militrVTaxSum = service.getTax(militaryVehicle);
        Assertions.assertEquals(0, militrVTaxSum);

    }

    private void setPassageTimeDuringJuly(AbstractVehicle vehicle) {
        vehicle.addPassageTime(toLocalDateTime("2013-07-07 06:23:27"));
        vehicle.addPassageTime(toLocalDateTime("2013-07-07 14:23:27"));
    }

    private void setPassageTimeOneHour(AbstractVehicle vehicle) {
        vehicle.addPassageTime(toLocalDateTime("2013-02-07 06:47:06"));
        vehicle.addPassageTime(toLocalDateTime("2013-02-07 07:17:46"));
    }

    private void setPassageTimePublicHoliday(AbstractVehicle vehicle) {
        vehicle.addPassageTime(toLocalDateTime("2013-12-19 15:58:06"));
        vehicle.addPassageTime(toLocalDateTime("2013-12-23 15:58:06"));
        vehicle.addPassageTime(toLocalDateTime("2013-12-24 06:47:06"));
    }

    private void setPassageTime3Days(AbstractVehicle vehicle) {
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
