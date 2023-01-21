package com.example.vehicle_cui;

import java.util.List;
import java.util.Map;

public class UI_Vehicle_View_Model {
    Map<String, String> vehicleDatas;
    List<Map<String, String>> ownersDatas;

    public Map<String, String> getVehicleDatas() {
        return vehicleDatas;
    }

    public void setVehicleDatas(Map<String, String> vehicleDatas) {
        this.vehicleDatas = vehicleDatas;
    }

    public List<Map<String, String>> getOwnersDatas() {
        return ownersDatas;
    }

    public void setOwnersDatas(List<Map<String, String>> ownersDatas) {
        this.ownersDatas = ownersDatas;
    }
}
