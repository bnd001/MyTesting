package com.learn.algo;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int a[] = { 1, 5, 4, 3 };
        int b[] = { 3, 1, 2, 4, 5 };

        System.out.println(maxVolByArea(a));
        System.out.println(maxVolByArea(b));

        System.out.println(maxArea(a, a.length));
        System.out.println(maxArea(b, b.length));
    }

    private static long maxVolByArea(int[] a) {
        int N = a.length;
        int lastIndex = N-1;
        int startIndex = 0;
        long maxArea = Integer.MIN_VALUE;
        long tmpAr = 0;

        while(startIndex < lastIndex) {
            tmpAr = (lastIndex - startIndex) * Integer.min(a[startIndex], a[lastIndex]);
            if (maxArea < tmpAr) {
                maxArea = tmpAr;
            }
            if (a[startIndex] < a[lastIndex]) {
                startIndex++;
            } else {
                lastIndex--;
            }
        }
        return maxArea;
    }


    //Same duplicate method from solution
    public static int maxArea(int A[], int len)
    {
        int l = 0;
        int r = len -1;
        int area = 0;

        while (l < r)
        {
            // Calculating the max area
            area = Math.max(area,
                    Math.min(A[l], A[r]) * (r - l));

            if (A[l] < A[r])
                l += 1;

            else
                r -= 1;
        }
        return area;
    }
}
