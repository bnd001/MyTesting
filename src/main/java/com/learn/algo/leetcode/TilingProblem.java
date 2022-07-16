package com.learn.algo.leetcode;

public class TilingProblem {

    static int getNoOfWays(int n)
    {

        // Base case
        if (n <= 2) { // when size of floor is 2xN tile = 2x1
            return n;
        }
        return getNoOfWays(n - 1) + getNoOfWays(n - 2);
    }

    static int getNoOfWaysMN(int n, int m)
    {

        // Base case
        if (n < m) { // when size of floor is mxN tile = mx1
            return 1;
        }
        if (n == m) {
            return 2;
        }
        return getNoOfWays(n - 1) + getNoOfWays(n - m);
    }

    // Driver Function
    public static void main(String[] args)
    {
        System.out.println(getNoOfWays(2));
        System.out.println(getNoOfWays(3));
        System.out.println("---Generic---");
        System.out.println(getNoOfWaysMN(4,2));
    }
}

