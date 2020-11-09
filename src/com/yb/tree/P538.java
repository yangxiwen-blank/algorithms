package com.yb.tree;

import java.util.*;

public class P538 {
    List<List<Integer>> res = new ArrayList<>();
    int[] res501 = null;

    /**
     * 538. 把二叉搜索树转换为累加树
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
     * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     */
    public TreeNode convertBST(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();
        TreeNode node = root;
        queue.offer(node);
        set.add(node);

        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.right != null && !set.contains(tmp.right)) {
                while (tmp != null) {
                    queue.offer(tmp);
                    set.add(tmp);
                    tmp = tmp.right;
                }
                tmp = queue.poll();
            }

            tmp.val = sum = sum + tmp.val;
            if (tmp.left != null) queue.offer(tmp.left);
        }

        return root;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return res;
    }

    private void levelOrder(TreeNode root, int i) {
        if (root == null) return;
        List<Integer> level = null;
        if (i >= res.size()) {
            level = new ArrayList<>();
        } else {
            level = res.get(i);
        }

        level.add(root.val);
        if (i >= res.size()) res.add(i, level);
        else res.set(i, level);

        if (root.left == null && root.right == null) return;
        levelOrder(root.left, i + 1);
        levelOrder(root.right, i + 1);
    }

    List<Integer>re = new ArrayList<>();
    /**
     * 501. 二叉搜索树中的众数
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     */
//    public int[] findMode(TreeNode root) {
//        if (res501 == null)
//        if (root==null)return null;
//        findMode(root.left);
//        re.add(root.val);
//        findMode(root.right);
//        return re.toArray();
//    }
}
