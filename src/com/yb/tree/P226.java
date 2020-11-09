package com.yb.tree;

import java.util.ArrayList;
import java.util.List;

public class P226 {
    List<Integer> list = new ArrayList<>();
    boolean isSymmetric = true;

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return isSymmetric;
        invertTree(root.right);
        isSymmetric(root.left, root.right);
        return isSymmetric;
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return isSymmetric;
        if (left == null || right == null || left.val != right.val) {
            isSymmetric = false;
            return false;
        }
        isSymmetric(left.left, right.left);
        isSymmetric(left.right, right.right);
        return isSymmetric;
    }

    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        boolean leftValid = isValidBST(root.left);
//        if (!leftValid) return false;
//        boolean rightValid = isValidBST(root.right);
//        if (!rightValid) return false;
//        if (root.left != null && root.left.val >= root.val) return false;
//        if (root.right != null && root.right.val <= root.val) return false;


//        List<Integer> bstList = inOrder(root, new ArrayList<>());
//        for (int i = 1, len = bstList.size(); i < len; ++i) {
//            if (bstList.get(i - 1) >= bstList.get(i)) return false;
//        }
//        return true;
        if (root == null) return true;
        isValidBST(root.left);
        if (list.size() == 0 || list.get(list.size() - 1) < root.val)
            list.add(root.val);
        else return false;
        isValidBST(root.left);
        return true;
    }

    public List<Integer> inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return list;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
        return list;
    }
}
