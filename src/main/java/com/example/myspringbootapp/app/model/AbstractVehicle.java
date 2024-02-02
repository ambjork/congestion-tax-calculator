package com.example.myspringbootapp.app.model;

import java.time.LocalDateTime;
import java.util.*;

public abstract class AbstractVehicle {

    String regNum;

    List<LocalDateTime> passageTimeList = new ArrayList<>();

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public List<LocalDateTime> getPassageTimes() {
        return passageTimeList;
    }

    public void setPassageTime(List<LocalDateTime> passageTimeList) {
        this.passageTimeList = passageTimeList;
    }

    public void addPassageTime(LocalDateTime newTime) {
        if (newTime != null) { passageTimeList.add(newTime); }
    }

    public abstract VehicleType getVehicleType();
}
