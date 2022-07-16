package com.learn.algo.leetcode;

public class Median2Array {


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {4,5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double result = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArray = new int[m+n];

        int k=0;

        int i=0,j=0;
        while(i<m && j <n) {

            if(nums1[i] <= nums2[j]) {
                mergedArray[k] = nums1[i];
                i++;
            } else {
                mergedArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        // check for rest of the element in larger array
        //int i,j;
        if (i < m) {
            //i=n;
            while (k < m+n) {
                mergedArray[k] = nums1[i];
                k++;
                i++;
            }
        }
        if (j < n) {
            //j=m;
            while (k < m+n) {
                mergedArray[k] = nums2[j];
                k++;
                j++;
            }
        }


        if ((m+n)%2 == 0) {
            result = mergedArray[(m-1+n-1)/2];
        } else {
            result = (double) ((double)mergedArray[(m-1+n-1)/2] + (double)mergedArray[((m-1+n-1)/2)+1])/2;
        }

        return result;
    }
}
