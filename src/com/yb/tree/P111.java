package com.yb.tree;

public class P111 {

    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     */
    public int minDepth(TreeNode root) {
        // 参数加1dfs
        //return minDepth(root, 1);

        // 返回值加1 dfs
        if (root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        if (root.left == null || root.right == null) return Math.max(m1, m2) + 1;
        return Math.min(m1, m2) + 1;
    }

    private int minDepth(TreeNode root, int i) {
        if (root == null) return i - 1;
        if (root.left == null && root.right == null) return i;
        if (root.left == null) return minDepth(root.right, i + 1);
        if (root.right == null) return minDepth(root.left, i + 1);
        return Math.min(minDepth(root.left, i + 1), minDepth(root.right, i + 1));
    }

}
