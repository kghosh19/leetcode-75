package com.leetcode.binarytreebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> views = new ArrayList<>();
        if(root == null) {
            return views;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            for(int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if(i == level - 1) {
                    views.add(node.val);
                }

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return views;
    }
}
