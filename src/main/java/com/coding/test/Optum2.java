package com.coding.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Optum2 {

    public static void main(String[] args) {
        solution();
    }

    public static void  solution() {
        int A[] = {7,3,7,3,1,3,4,1};
        int[] B = findUniqueDestinationCountSet(A);

        for (int i=0; i<B.length;i++){
            System.out.print(B[i] + ",");
        }
    }

    private static int[] findUniqueDestinationCountSet(int[] ar) {

        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
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
        System.out.println(hm.keySet());
        return resultArr;

    }

}
