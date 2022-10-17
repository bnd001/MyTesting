package com.learn.algo.leetcode;

import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {

        String str = "abcbcca";
        System.out.println(longestSubstring(str));

    }
    // wrong
    static String longestSubstring (String str) {
        int n = str.length();
        char[] str_char = str.toCharArray();
        int max = -1;
        String max_str;
        Queue<Character> charList = new LinkedList<>();
        int result = -1;
        for(int i=0; i < n; i++) {
            if(!charList.contains(str_char[i])) {
                charList.add(str_char[i]);
                max = Math.max(max, charList.size());
            } else {
                charList.poll();
                charList.add(str_char[i]);
            }
        }
        return  charList.toString();
    }
}
