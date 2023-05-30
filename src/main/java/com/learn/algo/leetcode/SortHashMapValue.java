package com.learn.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SortHashMapValue {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("sample1", 10);
        map.put("sample2", 1);
        map.put("sample3", 8);
        map.put("sample4", 6);
        map.put("sample5", 11);

        //Collect the values in list
        List<Integer> listEntry = map.entrySet().stream().map(o->o.getValue()).collect(Collectors.toList());

        HashMap<String, Integer> temp
                = map.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i1.getValue().compareTo(
                        i2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, HashMap::new));

        //map.entrySet().stream().sorted().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> b, link));

        Collections.sort(listEntry);
        System.out.println(listEntry);


    }
}
