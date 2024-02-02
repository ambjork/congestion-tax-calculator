package com.example.myspringbootapp.app.model;

public class Bus extends AbstractVehicle {



    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BUS;
    }
}
