package com.learn.algo.leetcode;

public class IntegerReversal {
    public static void main(String[] args) {
        int num = 51;
        System.out.println(intReversal(num));
    }

    public static int intReversal(int num) {
        int rev_num = 0;
        while(num > 0)
        {
            rev_num = rev_num * 10 + num % 10;
            num = num / 10;
        }
        return rev_num;
    }
}
