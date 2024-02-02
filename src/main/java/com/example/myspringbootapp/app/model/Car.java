package com.example.myspringbootapp.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Car extends AbstractVehicle {

    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }


}
