package com.leetcode.binarytreedfs;

public class BinaryTreeDFS {

    // 1. Pre-order Traversal (Root, Left, Right)
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " "); // Process current node
        preOrder(node.left);              // Traverse left subtree
        preOrder(node.right);             // Traverse right subtree
    }

    // 2. In-order Traversal (Left, Root, Right)
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);               // Traverse left subtree
        System.out.print(node.val + " "); // Process current node
        inOrder(node.right);              // Traverse right subtree
    }

    // 3. Post-order Traversal (Left, Right, Root)
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);             // Traverse left subtree
        postOrder(node.right);            // Traverse right subtree
        System.out.print(node.val + " "); // Process current node
    }

    public static void main(String[] args) {
        /*
            Constructing the following binary tree:
                    1
                   / \
                  2   3
                 / \
                4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeDFS tree = new BinaryTreeDFS();

        System.out.print("Pre-order Traversal:  ");
        tree.preOrder(root);
        System.out.println();

        System.out.print("In-order Traversal:   ");
        tree.inOrder(root);
        System.out.println();

        System.out.print("Post-order Traversal: ");
        tree.postOrder(root);
        System.out.println();
    }
}