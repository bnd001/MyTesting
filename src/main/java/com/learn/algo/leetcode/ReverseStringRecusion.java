package com.learn.algo.leetcode;

public class ReverseStringRecusion {

    public static void main(String[] args) {
        String str = "abcde";
        reverseFun(str);
    }

    static void reverseFun(String str) {
        if(str == null) {
            return ;
        }
        if (str.length() <= 0) {
            return ;
        }
        int index = str.length() -1;
        System.out.print(str.charAt(index));
        reverseFun(str.substring(0, index));// does substring from 0 to 1 char before index value

    }
}
