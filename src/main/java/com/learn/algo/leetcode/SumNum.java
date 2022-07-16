package com.learn.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumNum {

    public static void main(String[] args) {
    int nums[] = {3,2,4};
    int target = 6;
        System.out.println(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean isFound = false;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j< nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    isFound = true;
                    break;
                }
                if(isFound) {
                    break;
                }
            }
        }
        return result;
    }


    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length(); // assuming words won't be empty
        char str[] = s.toCharArray();
        for(int i=0; i< str.length; i++) {
            
        }

        return result;
    }
}
