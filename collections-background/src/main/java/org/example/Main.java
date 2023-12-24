package org.example;

import org.example.arrayList.CustomArrayList;
import org.example.hashmap.CustomHashMap;

public class Main {

    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();

        customHashMap.put("item1", 1);
        System.out.println(customHashMap.get("item1"));
    }

}