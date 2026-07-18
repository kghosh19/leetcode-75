package com.leetcode.binarytreedfs;

public class ZigZag {
    int longestPath = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return longestPath;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if(node == null)
            return;

        longestPath = Math.max(longestPath, length);

        if(isLeft) {
            dfs(node.right, false, length+1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.left, true, length+1);
            dfs(node.right, false, 1);
        }
    }
}
