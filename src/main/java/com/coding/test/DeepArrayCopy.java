package com.coding.test;

public class DeepArrayCopy {
    public static int[][] clone(int[][] input) {
        //TODO create a copy of all the elements in input and return to caller.
        int[][] copy = new int[input.length][];

        for(int i=0; i<input.length; i++) {
            copy[i] = new int[input[i].length];
            for(int j=0; j<input[i].length; j++) {
                copy[i][j] = input[i][j];
            }
        }

    // return new int[1][1];
    return copy;
}

    public static void main(String[] args) {
        int[][] test = new int[2][];
        test[0] = new int[] {42};
        int[][] testClone = clone(test);
        System.out.println("test clone value is: " + testClone[1][0]);
    }
}
