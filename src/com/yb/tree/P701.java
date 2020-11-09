package com.yb.tree;

public class P701 {
    /**
     * 701. 二叉搜索树中的插入操作<br>
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。<br>
     * 返回插入后二叉搜索树的根节点。 <br>
     * 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。<br>
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。<br>
     * 你可以返回任意有效的结果。
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode treeNode = root;
        while (root != null) {
            if (root.val <= val) {
                if (root.right != null)
                    root = root.right;
                else {
                    root.right = new TreeNode(val);
                    break;
                }
            } else {
                if (root.left != null)
                    root = root.left;
                else {
                    root.left = new TreeNode(val);
                    break;
                }
            }
        }
        return treeNode;
    }
}
