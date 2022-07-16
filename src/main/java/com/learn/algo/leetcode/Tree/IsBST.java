package com.learn.algo.leetcode.Tree;

public class IsBST {

    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(3);

        System.out.println(isBST(root));

    }

    static boolean isBST(Node node)
    {
        if (node == null)
            return true;

        /* False if left is > than node */
        if (node.left != null && node.left.data > node.data)
            return false;

        /* False if right is < than node */
        if (node.right != null && node.right.data < node.data)
            return false;

        /* False if, recursively, the left or right is not a BST */
        if (!isBST(node.left) || !isBST(node.right))
            return false;

        /* Passing all that, it's a BST */
        return true;
    }
}
