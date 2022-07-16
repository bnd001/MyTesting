package com.learn.algo.leetcode;

public class NumberOfIslan {
    public static void main(String[] args) {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 1 } };


        countIslands(M);
    }

    private static void countIslands(int[][] m) {
        int row=5;
        int col=5;
        int islandCount = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if(m[i][j] == 1) {
                    islandCount++;
                    m[i][j] = 2;
                    markOtherVisited(m,i ,j);
                }
            }
        }
        System.out.println("No. of Island " + islandCount);
    }

    private static void markOtherVisited(int[][] m, int i, int j) {
        //top
        if(i > 0 && m[i-1][j] == 1) {
            m[i-1][j] = 2;
            markOtherVisited(m,i-1 ,j);
        }
        //bottom
        if(i < 4 && m[i+1][j] == 1) {
            m[i+1][j] = 2;
            markOtherVisited(m,i+1 ,j);
        }
        //right
        if(j < 4 && m[i][j+1] == 1) {
            m[i][j+1] =2;
            markOtherVisited(m,i ,j+1);
        }
        //left
        if(j > 0 && m[i][j-1] == 1) {
            m[i][j-1] = 2;
            markOtherVisited(m,i ,j-1);
        }
    }
}
