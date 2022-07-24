package com.learn.algo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {

        String str = "abcbcca";
        System.out.println(longestSubstring(str));

    }

    static String longestSubstring (String str) {
        int n = str.length();
        char[] str_char = str.toCharArray();
        int max = -1;
        Map<String,Integer> charMap = new HashMap<>();
        int result = -1;
        for(int i=0; i < n; i++) {
            result = charMap.getOrDefault(str_char[i],0);
            if (result == 0) {
                charMap.put(String.valueOf(str_char[i]), 1);
            } else {
                // remove from beginning in charMap, add at the end

            }
            max = charMap.size();


        }
        return  null;
    }
}
