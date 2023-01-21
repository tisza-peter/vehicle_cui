package com.example.vehicle_cui;

import com.example.vehicle_core.*;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UI_Controller {
    VehicleCoreApplication myCore;

    Interactor_Interface myInteractor;

    public void SetCore(VehicleCoreApplication core)
    {
        myCore=core;
    }

    public void Start()
    {
        // create a BufferedReader using System.in
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String inputdata;
        String registrationNumber;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");
        System.out.println("Enter 'set' to new vehicle adding.");
        System.out.println("Enter 'get' to new vehicle adding.");
        do {

            try {
                inputdata = obj.readLine();
                if(inputdata.equals("get"))
                {
                    System.out.println("Enter registration number of vehicle to read its data.");
                    registrationNumber = obj.readLine();
                    GetVehicleRequestModel requestModel= new GetVehicleRequestModel();
                    requestModel.setRegistrationNumber(registrationNumber);
                    myCore.get(requestModel.getJson());

                }
                if(inputdata.equals("set"))
                {
                    NewVehicleRequestModel requestModel = new NewVehicleRequestModel();
                    VehicleEntity vehicle = new VehicleEntity();

                    System.out.println("Enter registration number of the new vehicle");
                    vehicle.setRegistrationNumber(obj.readLine());

                    System.out.println("Enter model of the new vehicle");
                    vehicle.setModel(obj.readLine());

                    System.out.println("Enter make of the new vehicle");
                    vehicle.setMake(obj.readLine());

                    System.out.println("Enter vehicle type of the new vehicle");
                    vehicle.setVehicleType(obj.readLine());

                    System.out.println("Enter seats number of the new vehicle");
                    vehicle.setNumberOfSeats(Integer.parseInt(obj.readLine()));

                    System.out.println("Enter the number of owners of the new vehicle");
                    int ownerNumber = Integer.parseInt(obj.readLine());

                    List<OwnerEntity> owners = new ArrayList<>();
                    for (int i = 1; i <= ownerNumber; i++) {
                        System.out.println("Enter the name of the "+ Integer.toString(i)+". owner of the new vehicle");
                        String ownerName = obj.readLine();
                        System.out.println("Enter the address of the "+ Integer.toString(i)+". owner of the new vehicle");
                        String ownerAddress = obj.readLine();
                        owners.add(new OwnerEntity(ownerName,ownerAddress));
                    }
                    requestModel.setVehicle(vehicle);
                    requestModel.setOwners(owners);
                    myCore.save(requestModel.getJson());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }   while(!inputdata.equals("stop"));
    }
}
