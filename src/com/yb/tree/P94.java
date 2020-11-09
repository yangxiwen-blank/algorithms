package com.yb.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P94 {

    List<Integer> res = new ArrayList<>();

    /**
     * 94. 二叉树的中序遍历<br>
     * 给定一个二叉树，返回它的中序 遍历。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public List<Integer> inorderTraversalBfs(TreeNode root) {
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
        while (!queue.isEmpty() || root != null) {
            while (root != null) {
                queue.offer(root);
                root = root.left;
            }

            root = queue.poll();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


}
