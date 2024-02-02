package com.example.myspringbootapp.app.model;

public class Motorbike extends AbstractVehicle {


    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MOTORBIKE;
    }
}
