package com.example.myspringbootapp.app.service;

import com.example.myspringbootapp.app.model.AbstractVehicle;
import com.example.myspringbootapp.app.model.VehicleType;
import com.example.myspringbootapp.app.util.CongestionTaxCalculator;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public int getTax(AbstractVehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();

        if (vehicleType == VehicleType.CAR || vehicleType == VehicleType.MOTORBIKE) {
        return CongestionTaxCalculator.getTax(vehicle);
        }

        return 0;
    }
}
