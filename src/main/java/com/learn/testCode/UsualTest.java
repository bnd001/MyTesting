package com.learn.testCode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class UsualTest {

    public static void main(String[] args) {
        Hashtable<String,Integer> sampleMap;
        sampleMap = new Hashtable<>();

        sampleMap.put("abc",1);
        sampleMap.put("xyz",2);
        sampleMap.put("xyz",2);
        System.out.println(sampleMap.size());

        Integer i = sampleMap.get("abd");
        System.out.println(i);

    }
}
