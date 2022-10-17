package com.learn.algo;

import java.util.HashMap;

public class MiniMunSubarray {

    public static void main(String[] args) {
        int A[] = { 7,3,7,3,1,3,4,1 };
        int B[] = findUniqueDestinationCountSet(A);

//        int A[] = { 5, 6, 5, 2, 7, 5, 6, 7, 5, 5, 7 };
//        int B[] = { 5, 5, 7 };
        int n = A.length;
        int m = B.length;
        //System.out.println(minimumSubArray(A, n, B, m));
        //System.out.println(lengthMin(A, n, B, m));
        minRange(A,n,m);
    }
    private static int lengthMin(int A[], int n, int B[], int m) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n - m + 1; i++) {
            if (A[i] == B[0]) {
                int j = 0, idx = i;
                for (; idx < n; idx++) {
                    if (A[idx] == B[j])
                        j++;
                    if (j == m)
                        break;
                }
                if (j == m && res > idx - i + 1)
                    res = (idx == n) ? idx - i : idx - i + 1;
            }
        }
        return res;
    }

    private static int[] findUniqueDestinationCountSet(int[] ar) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            hm.put(ar[i], i);
        }
        int len = hm.size();
        int i = 0;
        int[] resultArr = new int[len];
        for (Integer in : hm.keySet()) {
            resultArr[i] = in.intValue();
            i++;
        }
        // System.out.println(hm.keySet());
        return resultArr;

    }

    static int minRange(int arr[], int n, int k)
    {
        int start = 0, end = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            j++;
            if (map.size() < k)
                continue;
            while (map.size() == k)
            {
                int windowLen = (j - 1) - i + 1;
                int subArrayLen = end - start + 1;
                if (windowLen < subArrayLen) {
                    start = i;
                    end = j - 1;
                }
                if (map.get(arr[i]) == 1)
                    map.remove(arr[i]);
                else
                    map.put(arr[i], map.get(arr[i]) - 1);
                i++;
            }
        }
        if (start == 0 && end == n)
            System.out.println("Invalid k");

        else
            System.out.println(start + " " + end);
        return end - start + 1;
    }


    // Returns the minimum length of sub_array
    static int minimumSubArray(int A[], int n,
                               int B[], int m)
    {
        int result = Integer.MAX_VALUE;

        // Traverse main_array element
        for (int i = 0; i < n - m + 1; i++)
        {
            // Pick only those subarray of
            // main_array whose first element
            // match with the first element
            // of second_array
            if (A[i] == B[0]) {

                // initialize starting of
                // both subarrays
                int j = 0, index = i;
                for (; index < n; index++) {
                    if (A[index] == B[j])
                        j++;

                    // if we found all elements
                    // of second array
                    if (j == m)
                        break;
                }

                // update minimum length sub_array
                if (j == m && result > index - i + 1)
                    result = (index == n) ? index - i :
                            index - i + 1;
            }

        }

        // return minimum length subarray
        return result;
    }

}
