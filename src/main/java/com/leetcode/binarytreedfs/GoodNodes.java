package com.leetcode.binarytreedfs;

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if(node == null)
            return 0;

        int goodCount = 0;
        if(node.val >= maxSoFar) {
            goodCount = 1;
            maxSoFar = node.val;
        }

        goodCount += dfs(node.left, maxSoFar);
        goodCount += dfs(node.right, maxSoFar);

        return goodCount;
    }
}
