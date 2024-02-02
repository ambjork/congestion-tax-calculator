package com.example.myspringbootapp.app.model;

public class ForeignVehicle extends AbstractVehicle {



    @Override
    public VehicleType getVehicleType() { return VehicleType.FOREIGN_VEHICLE; }
}
