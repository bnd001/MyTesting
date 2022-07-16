package com.coding.test;

import java.util.ArrayList;
import java.util.List;

public class BlueOptima {


    public static void main(String[] args) {
        for (String s : sequence(18)) {
            System.out.print(s);
        }
    }


    public static List<String> sequence(int N) {
        List<String> results = new ArrayList<>();
        // Add your code here
        boolean isSix =false ,isSeventeen = false;
        String value = "";
        for(int i=1;i<=N;i++) {
            isSeventeen = false;
            isSix = false;
            value = Integer.toString(i);
            if(i%6 == 0) {
                isSix = true;
                value = "Goose";
            }

            if(i%17 == 0) {
                isSeventeen = true;
                value = "Lion";
            }
            if (isSeventeen && isSix) {
                value = "LionGoose";
            }
            results.add(value);
        }
        return results;
    }
}
