package com.learn.algo.leetcode;

public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "lllabcbayzxg";
        System.out.println(longestPalin(str));
    }

    //it only return length of longest palindrome substring
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


    // brute force - working
    private static String longestPalin(String str) {
        int n = str.length();
        String subString = "";
        int lenLongest = 0;
        int  start = 0,end = 0;

        // is the given String is palindrome return
        if(isPalindrome(str)) {
            lenLongest = n;
            return str;
        }
        // iterating from the largest String after the String itself
        for (int i=n; i >1; i--) {
            for (int j=0;j<n-2;j++) {
                if(j<i) {
                    // break if it single letter
                    if(i-j == 1) {
                        break;
                    }
                    subString = str.substring(j, i);
                    if (isPalindrome(subString)) {
                        if (lenLongest < subString.length()) {
                            lenLongest = subString.length();
                            start = j;
                            end = i;
                        }
                    }
                }

            }
        }

        return str.substring(start,end);
    }

    static boolean isPalindrome(String str) {
        if(str.equals(reverseString(str))) {
            return true;
        }
        return false;
    }

    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder reversed = new StringBuilder(input.length());

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }

}
