package com.learn.algo.leetcode;

import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {

        String str = "abcbccaefgca";
        System.out.println(longestSubStr(str));
        longestUniqueSubsttr(str);

    }

    //Complexity is O(n^3)
    static String longestSubStr(String str) {
        int n = str.length();
        if(n==1) {
            return str;
        }
        int index_start =0,index_end =0;
        int res_length = 0;
        String uniqueString = "";
        //use sliding window
        for (int i=0; i <n; i++) {
            for (int j=i; j<n; j++) {
                if(areDistinct(str,i,j) && res_length < (j-i)) { // also check length of longest
                    index_start = i;
                    index_end = j;
                    res_length = j-i;
                }
            }
        }
        uniqueString = str.substring(index_start, index_end +1);
        return uniqueString;
    }
//    public static Boolean areDistinct1(String str,
//                                      int i, int j)
//    {
//
//        // Note : Default values in visited are false
//        boolean[] visited = new boolean[26];
//
//        for(int k = i; k <= j; k++)
//        {
//            if (visited[str.charAt(k) - 'a'])
//                return false;
//
//            visited[str.charAt(k) - 'a'] = true;
//        }
//        return true;
//    }
    public static Boolean areDistinct(String str,int i, int j) {

        Map<Character,Integer> charMap = new HashMap<>();

        for(int k=i; k<=j; k++) {
            Integer count  = charMap.getOrDefault(str.charAt(k), 0);
            if (count > 0) {
                return false;
            } else {
                charMap.put(str.charAt(k),1);
            }
        }
        return true;
    }


    //sliding window
    public static int longestUniqueSubsttr(String str) {
        int n = str.length();
        // Result
        int res = 0;
        int index_start = 0, index_end=0;
        for (int i = 0; i < n; i++) {
            // Note : Default values in visited are false
            boolean[] visited = new boolean[256];
            for (int j = i; j < n; j++) {
                // If current character is visited
                // Break the loop
                if (visited[str.charAt(j)] == true)
                    break;

                    // Else update the result if
                    // this window is larger, and mark
                    // current character as visited.
                else {
                    if (res < j-i) {
                        res =  j - i ;
                        index_start = i;
                        index_end = j;
                    }

                    visited[str.charAt(j)] = true;
                }
            }

            // Remove the first character of previous
            // window
            visited[str.charAt(i)] = false;
        }
        System.out.println(str.substring(index_start, index_end + 1));
        return res;
    }




}
