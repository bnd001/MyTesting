package com.coding.test;

import java.io.*;
import java.util.*;


public class SequenceSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int S = Integer.parseInt(br.readLine().trim());
            int X = Integer.parseInt(br.readLine().trim());
            int Y = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            // int out_ = solve(N, S, X, Y, A);

            int out_ = solve(5, 2, X, Y, A);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static int solve(int N, int S, int X, int Y, int[] A){
        // Write your code here
        int result = 0;
        int max = findMax(A);
        int min = findMin(A);

        int diff = max-min;
        int set = 0;
        for(int i=0; i< A.length; i++) {
            for(int j=0; j<A.length; j++) {
                if(A[j] >= min && A[j]<= min) {
                    set ++;
                }
                if (set == S) {
                    set = 0;
                    result ++;
                    break;
                }
            }

        }

        return result;

    }

    static int findMax(int[] A) {
        int tmp = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++) {
            if(A[i] > tmp) {
                tmp = A[i];
            }
        }

        return tmp;
    }
    static int findMin(int[] A) {
        int tmp = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++) {
            if(A[i] < tmp) {
                tmp = A[i];
            }
        }

        return tmp;
    }
}
