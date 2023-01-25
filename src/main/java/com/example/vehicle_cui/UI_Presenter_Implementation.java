package com.example.vehicle_cui;

import com.example.vehicle_core.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class UI_Presenter_Implementation implements UI_Presenter_Interface {

    @Override
    public void DisplayOneVehicle(String getVehicleResponseModelJSON) {
        GetVehicleResponseModel ResponseModel = new GetVehicleResponseModel();
        try {
            ResponseModel.setByJson(new JSONObject(getVehicleResponseModelJSON));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        VehicleEntity vehicle = ResponseModel.getVehicle();
        List<OwnerEntity> owners = ResponseModel.getOwners();
        UI_Vehicle_View_Model viewModel = new UI_Vehicle_View_Model();

        Map<String, String> vehicleDatas = new HashMap<>();
        vehicleDatas.put("registrationNumber",vehicle.getRegistrationNumber());
        vehicleDatas.put("make",vehicle.getMake());
        vehicleDatas.put("model",vehicle.getModel());
        vehicleDatas.put("numberOfSeats",Integer.toString(vehicle.getNumberOfSeats()));
        vehicleDatas.put("vehicleType",vehicle.getVehicleType());
        viewModel.setVehicleDatas(vehicleDatas);

        Map<String, String> ownerDatas;
        List<Map<String, String>> ownersDatas = new ArrayList<>();
        for (OwnerEntity owner:owners) {
            ownerDatas = new HashMap<>();
            ownerDatas.put("name",owner.getName());
            ownerDatas.put("address",owner.getAddress());
            ownersDatas.add(ownerDatas);
        }
        viewModel.setOwnersDatas(ownersDatas);
        UI_View view=new UI_View();
        view.setVehicleViewModel(viewModel);
        view.printVehicle();
    }

    @Override
    public void DisplaySaveStatus(String newVehicleResponseModelJSON) {
        NewVehicleResponseModel responseModel = new NewVehicleResponseModel();
        try {
            responseModel.setByJson(new JSONObject(newVehicleResponseModelJSON));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        System.out.print("New vehicle registration status: ");
        System.out.println(responseModel.getStatus());
    }
}
