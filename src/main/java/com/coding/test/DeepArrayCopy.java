package com.coding.test;

import java.util.Arrays;

public class DeepArrayCopy {
    public static int[][] clone(int[][] input) {
        //TODO create a copy of all the elements in input and return to caller.
        if(input == null) {
            return null;
        }
        int[][] copy = new int[input.length][];

        for(int i=0; i<input.length; i++) {
            copy[i] = Arrays.copyOf(input[i], input[i].length);
        }

    // return new int[1][1];
    return copy;
}

    public static void main(String[] args) {
        int[][] test = new int[2][];
        test[0] = new int[] {42,43,44};
        test[1] = new int[] {45,46,47,48,49};
        int[][] testClone = clone(test);
        System.out.println("test clone value is: " + testClone.length);
    }
}
