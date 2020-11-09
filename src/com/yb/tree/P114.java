package com.yb.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class P114 {
    Deque<TreeNode> deque114 = new ArrayDeque<>();

    /**
     * 114. 二叉树展开为链表
     * 给定一个二叉树，原地将它展开为一个单链表。
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = new TreeNode(0);
        tmp.right = root;

        dfs114(root);

        while (!deque114.isEmpty()) {
            root.left = null;
            root.right = deque114.pop();
            root = root.right;
        }
        root.left = null;
        root = tmp.right;

    }

    private void dfs114(TreeNode root) {
        if (root == null) return;
        dfs114(root.right);
        if (root.right != null) deque114.push(root.right);
        dfs114(root.left);
        if (root.left != null) deque114.push(root.left);
    }
}
