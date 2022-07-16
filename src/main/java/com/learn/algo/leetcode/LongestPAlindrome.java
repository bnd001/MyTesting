package com.learn.algo.leetcode;

public class LongestPAlindrome {

    public static void main(String[] args) {
        String str = "tregddabcbawwe";
        System.out.println(longestPalindrome(str));
    }
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}
