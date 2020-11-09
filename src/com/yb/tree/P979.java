package com.yb.tree;

public class P979 {
    int res = 0;

    /**
     * 979. 在二叉树中分配硬币<br>
     * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。<br>
     * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。<br>
     * (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。<br>
     * 返回使每个结点上只有一枚硬币所需的移动次数<br>
     */
    public int distributeCoins(TreeNode root) {

        return 0;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);

        //|| (root.left == null && root.right == null)
        if (root.left != null && root.left.val != 1)
            root.val += root.left.val - 1;
        if (root.right != null && root.right.val != 1)
            root.val += root.right.val - 1;

        res += Math.abs(root.val);

    }
}
