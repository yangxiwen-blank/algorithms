package com.yb.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145 {
    List<Integer> res = new ArrayList<>();

    /**
     * 145. 二叉树的后序遍历<br>
     * 给定一个二叉树，返回它的 后序 遍历。
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    public List<Integer> postorderTraversalBfs(TreeNode root) {
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || prev == root.right) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }

        }
        return res;
//        stack.push(root);
//            TreeNode cur = stack.peek();
//            if (cur.left == null && cur.right == null) {
//                stack.pop();
//                res.add(cur.val);
//            }
    }
}
