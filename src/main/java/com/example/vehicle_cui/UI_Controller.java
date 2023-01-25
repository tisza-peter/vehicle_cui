package com.example.vehicle_cui;

import com.example.vehicle_core.VehicleCoreApplication;
import com.example.vehicle_core.Interactor_Interface;

import java.util.ArrayList;
import java.util.List;

public class UI_Controller {
    VehicleCoreApplication myCore;
    UI_View view=new UI_View();

    Interactor_Interface myInteractor;

    public void SetCore(VehicleCoreApplication core)
    {
        myCore=core;
    }

    public void Start()
    {
        String command;
        view.PrintAvailableCommands();
        do {
            command=view.GetCommand();
            if(command.equals("get"))
            {
                String registrationNumber = view.GetRegistrationNumberFromConsole();
                GetVehicleRequestModel requestModel= new GetVehicleRequestModel();
                requestModel.setRegistrationNumber(registrationNumber);
                myCore.get(requestModel.getJson().toString());
            }
            if(command.equals("set"))
            {
                NewVehicleRequestModel requestModel = new NewVehicleRequestModel();
                VehicleEntity vehicle = new VehicleEntity();
                List<OwnerEntity> owners = new ArrayList<>();
                view.GetVehicleFromConsole(vehicle,owners);
                requestModel.setVehicle(vehicle);
                requestModel.setOwners(owners);
                myCore.save(requestModel.getJson().toString());
            }
        }while (!command.equals("stop"));
    }
}
