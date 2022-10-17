package com.coding.test;

public class SamllestPositiveInteger {
    public static void main(String[] args) {
        int [] arr = {1, 3, 6, 4, 1, 2};

            System.out.println(solution(arr));

        }

        public static int solution(int[] A) {
            // write your code in Java SE 8
            int smallIntToFind = 1;
            boolean isFound = true;

            //Find smallIntToFind , if not found find smallIntToFind++
            while(isFound) {
                isFound = false;
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == smallIntToFind) {
                        isFound = true;
                        smallIntToFind ++;
                        break;
                    }
                }
            }
            return smallIntToFind;
        }
    }

