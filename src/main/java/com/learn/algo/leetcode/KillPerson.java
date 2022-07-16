package com.learn.algo.leetcode;

public class KillPerson {
    public static void main(String[] args) {
        int person = 10;

        // Placeholder array for person
        int[] a = new int[person];

        // Assign placeholders from 1 to N (total person)
        for (int i = 0; i < person; i++) {
            a[i] = i + 1;
        }

        // Will start the game from 1st person (Which is at
        // placeholder 0)
        int pos = 0;

        // Game will be continued till we end up with only one
        // person left
        while (a.length > 1)
        {

            // Current person will shoot the person next to
            // him/her. So incrementing the position.
            pos++;

            // As person are standing in circular manner, for
            // person at last place has right neighbour at
            // placeholder 0. So we are taking modulo to make it
            // circular
            pos %= a.length;
            //pos = pos % a.length;

            // Killing the person at placeholder 'pos'
            // To do that we simply remove that element
            int[] anotherArray = new int[a.length - 1];
            System.arraycopy(a, 0, anotherArray, 0, pos);

            // skipping the element just next to pos(index)
            //starting from pos+1
            System.arraycopy(a, pos + 1, anotherArray, pos,(a.length-1) - pos);
            a = anotherArray;

            // There is no need to increment the pos again to
            // pass the gun Because by erasing the element at
            // 'pos', now next person will be at 'pos'.
        }

        // Print Person that survive the game
        System.out.println(a[0]);
    }
}
