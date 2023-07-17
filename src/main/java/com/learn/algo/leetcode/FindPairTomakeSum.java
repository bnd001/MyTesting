package com.learn.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindPairTomakeSum {

    public static void findPairs(int[] array) {
        Set<Integer> set = new HashSet<>();
        Set<Pair> pairs = new HashSet<>();

        for (int num : array) {
            int complement = 100 - num;

            if (set.contains(complement)) {
                pairs.add(new Pair(num, complement));
            } else {
                set.add(num);
            }
        }

        if (pairs.isEmpty()) {
            System.out.println("No pairs found.");
        } else {
            System.out.println("Pairs whose sum is 100:");
            for (Pair pair : pairs) {
                System.out.println(pair);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 10, 90};
        findPairs(array);
    }

    private static class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        /*@Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair other = (Pair) obj;
            return (first == other.first && second == other.second) ||
                    (first == other.second && second == other.first);
        }

        @Override
        public int hashCode() {
            return first + second;
        }
*/
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
}

