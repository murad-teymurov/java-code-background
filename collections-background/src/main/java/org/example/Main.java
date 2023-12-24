package org.example;

import org.example.arrayList.CustomArrayList;

public class Main {

    public static void main(String[] args) {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();

        int elementssize = 11;

        for(int i = 0; i< elementssize; i++) {
          customArrayList.add("item: " + i);
        }

        System.out.println("size: " + customArrayList.getSize());
        System.out.println("capacitance: " + customArrayList.getCapacitance());
        System.out.println(customArrayList.get(5));

        for(int i = 0; i< customArrayList.getSize(); i++) {
            System.out.println(customArrayList.get(i));
        }
    }

}