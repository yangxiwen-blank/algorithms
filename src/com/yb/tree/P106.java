package com.yb.tree;

import java.util.Arrays;
import java.util.Map;

public class P106 {

    public static void main(String[] args) {
        System.out.println(new P106().buildTree(
                new int[]{8, 9, 6, 3, 19, 15, 20, 7},
                new int[]{8, 6, 9, 19, 15, 7, 20, 3}));
    }

    /**
     * 106. 从中序与后序遍历序列构造二叉树<br>
     * 根据一棵树的中序遍历与后序遍历构造二叉树。<br>
     * 注意:<br>
     * 你可以假设树中没有重复的元素。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;

        int val = postorder[len - 1];
        TreeNode root = new TreeNode(val);
        if (len == 1) return root;

        int pos = -1;
        for (int i = 0; i < len; ++i) {
            if (inorder[i] == val) {
                pos = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, pos), Arrays.copyOfRange(postorder, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(inorder, pos + 1, len), Arrays.copyOfRange(postorder, pos, len - 1));
        return root;
//        return buildTree(inMap, postMap, postorder[len - 1], 0, len - 1);
    }

    public TreeNode buildTree(Map<Integer, Integer> inMap, Map<Integer, Integer> postMap, int head, int start, int end) {
        TreeNode root = new TreeNode(head);
        int pos = inMap.get(head);
        if (pos > start)
            root.left = buildTree(inMap, postMap, postMap.get(pos - start - 1), start, pos - 1);
        if (pos < end)
            root.right = buildTree(inMap, postMap, postMap.get(end - 1), pos, end - 1);
        return root;
    }
}
