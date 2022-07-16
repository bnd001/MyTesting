package com.learn.algo.leetcode.Tree;

import java.lang.reflect.Array;
import java.util.Arrays;

// Java program to print reverse level order
// traversal of a binary tree in spiral form
public class BinaryTreeSpiralTraversal {

    // Binary tree Node
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    };

    // Recursive Function to find height
    // of binary tree
    static int height(Node root)
    {
        if (root == null)
            return 0;
        // Compute the height of each subtree
        int lheight = height(root.left);
        int rheight = height(root.right);
        // Return the maximum of two
        return Math.max(lheight + 1, rheight + 1);
    }

    // Function to Print Nodes from right to left
    static void rightToLeft(Node root, int level)
    {
        if (root == null)
            return;

        if (level == 1)
            System.out.print(root.data + " ");

        else if (level > 1) {
            rightToLeft(root.right, level - 1);
            rightToLeft(root.left, level - 1);
        }
    }

    // Function to Print Nodes from left to right
    static void leftToRight(Node root, int level)
    {
        if (root == null)
            return;

        if (level == 1)
            System.out.print(root.data + " ");

        else if (level > 1) {
            leftToRight(root.left, level - 1);
            leftToRight(root.right, level - 1);
        }
    }

    // Function to print Reverse level order traversal
    // of a Binary tree in spiral form
    static void reverseSpiral(Node root)
    {
        // Flag is used to mark the change
        // in level
        int flag = 1;

        // Height of tree
        int h = height(root);

        for (int i = h; i >= 1; i--) {

            // If flag value is one print Nodes
            // from left to right
            if (flag == 1) {
                leftToRight(root, i);

                // Mark flag as zero so that next time
                // tree is traversed from right to left
                flag = 0;
            }

            // If flag is zero print Nodes
            // from right to left
            else if (flag == 0) {
                rightToLeft(root, i);

                // Mark flag as one so that next time
                // Nodes are printed from left to right
                flag = 1;
            }
        }
    }

    // Driver code
    public static void main(String args[])
    {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.right.right = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);

        reverseSpiral(root);
    }

    int MissingNumber(int array[], int n) {
        // Your Code Here
        int len = array.length;
        Arrays.sort(array);
        for(int i=1; i <= len; i++) {
            if(!(i == array[i-1])) {
                return i;
            }
        }
        return n;
    }

    static void transformTree (Node root)
    {
        if(root == null) {
            return;
        }
    }
}

// This code is contributed by Arnab Kundu

