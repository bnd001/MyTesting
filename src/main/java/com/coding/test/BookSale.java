package com.coding.test;

import java.util.*;

public class BookSale {
    public static int nthLowestSelling(int[] sales, int n) {

        Hashtable<Integer,Integer> count = new Hashtable<>();
        List<Integer> salesCount = new ArrayList<Integer>();

       for (int i=0; i< sales.length; i++) {
           if (count.get(sales[i]) == null) {
               count.put(sales[i],1);
           } else {
               count.put(sales[i],count.get(sales[i]) + 1);
           }
       }
        Enumeration<Integer> e = count.keys();
        while (e.hasMoreElements()) {
            salesCount.add(count.get(e.nextElement()));
        }
        Collections.sort(salesCount);

        Integer integer = salesCount.get(n-1);
        int result = -1;

        Enumeration<Integer> e1 = count.keys();
        while (e1.hasMoreElements()) {
            int nxt = e1.nextElement();
            if (count.get(nxt) == integer) {
                result = nxt;
                break;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        int x = nthLowestSelling(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }
}
