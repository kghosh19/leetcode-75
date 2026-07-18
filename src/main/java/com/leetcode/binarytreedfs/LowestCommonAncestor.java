package com.leetcode.binarytreedfs;

//        3
//       / \
//      5   1
//     / \ / \
//    6  2 0  8
//     / \
//    7   4

public class LowestCommonAncestor {
    void main() {
        Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.buildTree(values);
        
        // Find nodes with values 5 and 1 in the tree
        TreeNode p = findNode(root, 6);
        TreeNode q = findNode(root, 4);
        
        TreeNode result = lowestCommonAncestor(root, p, q);
        IO.println(result.val);
    }

    private TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
