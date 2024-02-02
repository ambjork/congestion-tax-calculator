package com.example.myspringbootapp.app.model;

public class EmergencyVehicle extends AbstractVehicle {



    @Override
    public VehicleType getVehicleType() {
        return VehicleType.EMERGENCY_VEHICLE;
    }
}
