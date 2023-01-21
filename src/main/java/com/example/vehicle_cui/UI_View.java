package com.example.vehicle_cui;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class UI_View {
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


}
