package com.learn.algo.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayKfrequency {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,4,5,5,5,5};
        int k = 2;
        int[] result = findKfrequent(arr, k);
    }

    private static int[] findKfrequent(int[] arr, int k) {
        int len = arr.length;
        int val = 0;
        int[] resultArray = new int[k];
        Map<Integer,Integer> integerMap = new HashMap<Integer,Integer>();
        for(int i=0; i < len ; i++) {
            if (integerMap.get(arr[i]) == null) {
                integerMap.put(arr[i], 1);
            } else {
                val = integerMap.get(arr[i]);
                integerMap.put(arr[i], val +1);
            }
        }
        //sort map by value
        List<Map.Entry> sortedList = integerMap.entrySet().stream().
                sorted((i1,i2) -> i2.getValue().compareTo(i1.getValue())).
                collect(Collectors.toList());
        for (int i=0 ; i<k; i++) {
            resultArray[i] = (int) sortedList.get(i).getKey();
            System.out.print(resultArray[i]+ " ");
        }
        return resultArray;
    }
}
