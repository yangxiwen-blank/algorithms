package com.yb.tree;

public class P110 {
    boolean isBalance110 = true;

    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        isBalanced(root, 0);
        return isBalance110;
    }

    private int isBalanced(TreeNode root, int dep) {
        if (root == null) {
            return dep - 1;
        }
        int left = isBalanced(root.left, dep + 1);
        int right = isBalanced(root.right, dep + 1);

        if (Math.abs(left - right) > 1) {
            isBalance110 = false;
        }
        return Math.max(left, right);
    }
}
