package com.example.vehicle_cui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UI_View {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private UI_Vehicle_View_Model vehicleViewModel;
    public void printVehicle(){
        System.out.println("vehicle datas is:");
        printMap(vehicleViewModel.getVehicleDatas());
        System.out.println("owners datas is:");
        printMapList(vehicleViewModel.getOwnersDatas());
    }

    private void printMapList(List<Map<String, String>> datas) {
        System.out.println("Number of owners is: "+Integer.toString(datas.size()));
        for (Map<String, String> data:datas) {
            printMap(data);
        }
    }


    private void printMap(Map<String, String> datas) {
        int keysMaxLength = maxLength(datas.keySet());
        int valuesMaxLength = maxLength(datas.values());
        System.out.print("/");
        System.out.print("-".repeat( keysMaxLength+valuesMaxLength+5));
        System.out.println("\\");
        for (Map.Entry<String, String> data:datas.entrySet()) {
            System.out.print("| ");
            System.out.print(data.getKey());
            System.out.print(" ".repeat(1+keysMaxLength-data.getKey().length()));
            System.out.print("| ");
            System.out.print(data.getValue());
            System.out.print(" ".repeat(1+valuesMaxLength-data.getValue().length()));
            System.out.println("|");
        }
        System.out.print("\\");
        System.out.print("-".repeat( keysMaxLength+valuesMaxLength+5));
        System.out.println("/");
    }

    public void setVehicleViewModel(UI_Vehicle_View_Model vehicleViewModel) {
        this.vehicleViewModel = vehicleViewModel;
    }

    public static int maxLength(Collection<String> strings) {
        if (strings == null)
            throw new NullPointerException("strings cannot be null");
        Iterator<String> i = strings.iterator();
        int max = 0;
        while (i.hasNext()) {
            String str = i.next();
            if (str != null) {
                int l = str.length();
                if (l > max) {
                    max = l;
                }
            }
        }
        return max;
    }


    public void ConsoleStart() {
    }

    public void PrintAvailableCommands() {
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");
        System.out.println("Enter 'set' to new vehicle adding.");
        System.out.println("Enter 'get' to new vehicle adding.");
    }

    public String GetCommand()  {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String GetRegistrationNumberFromConsole()  {
        System.out.println("Enter registration number of vehicle to read its data.");
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void GetVehicleFromConsole(VehicleEntity vehicle, List<OwnerEntity> owners) {
        try {

            System.out.println("Enter registration number of the new vehicle");
            vehicle.setRegistrationNumber(reader.readLine());

            System.out.println("Enter model of the new vehicle");
            vehicle.setModel(reader.readLine());

            System.out.println("Enter make of the new vehicle");
            vehicle.setMake(reader.readLine());

            System.out.println("Enter vehicle type of the new vehicle");
            vehicle.setVehicleType(reader.readLine());

            System.out.println("Enter seats number of the new vehicle");
            vehicle.setNumberOfSeats(Integer.parseInt(reader.readLine()));

            System.out.println("Enter the number of owners of the new vehicle");
            int ownerNumber = Integer.parseInt(reader.readLine());

            for (int i = 1; i <= ownerNumber; i++) {
                System.out.println("Enter the name of the "+ Integer.toString(i)+". owner of the new vehicle");
                String ownerName = reader.readLine();
                System.out.println("Enter the address of the "+ Integer.toString(i)+". owner of the new vehicle");
                String ownerAddress = reader.readLine();
                owners.add(new OwnerEntity(ownerName,ownerAddress));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
