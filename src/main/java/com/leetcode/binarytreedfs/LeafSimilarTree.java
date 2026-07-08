package com.leetcode.binarytreedfs;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        var leafList1 = new ArrayList();
        var leafList2 = new ArrayList();

        traversal(root1, leafList1);
        traversal(root2, leafList2);

        return leafList1.equals(leafList2);
    }

    private void traversal(TreeNode node, List<Integer> leafList) {
        if(node == null)
            return;

        if (node.left == null && node.right == null) {
            leafList.add(node.val);
            return;
        }

        traversal(node.left, leafList);
        traversal(node.right, leafList);
    }
}
