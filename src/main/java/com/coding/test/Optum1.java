package com.coding.test;

public class Optum1 {

    public static void main(String[] args) {
    String s = "aaaa";
    int [] cost = {3,4,5,6};
        System.out.println(solution(s,cost));
    }

    public static int solution(String S, int[] C) {
        char[] charArr = S.toCharArray();
        int len = S.length();
        int minCostSum = 0;
        int start=-1;
        int end=-1;
        int j;
        for(int i=0; i<len-1;) {
            end = -1;
            start = i;
            j = i;
            while(j < len-1 && charArr[j] == charArr[j+1]) {
                end = j+1;
                j++;
            }
            if (end != -1) {
                minCostSum += findMinCostSubstring(getSubArray(C, start, end), (end-start) +1);
            }
            i = j+1;
        }
        return minCostSum;
    }

    public static int findMinCostSubstring(int[] x, int len) {
        // find highest in array
        int minCumCost = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i< len; i++) {
            max = Math.max(x[i], max);
        }
        for (int i=0; i < len; i++) {
            if(x[i] != max) {
                minCumCost += x[i];
            }
        }
        return minCumCost;
    }
    public static int[] getSubArray(int[] A, int start, int end) {
        int len = (end - start) + 1;
        int[] subArray = new int[len];
        int j=0;
        for (int i = start; i<= end; i++) {
            subArray[j] = A[i];
            j++;
        }
        return subArray;
    }
}
