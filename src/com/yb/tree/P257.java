package com.yb.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P257 {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        binaryTreePath(root, new StringBuilder());
        return res;
    }

    public void binaryTreePath(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        binaryTreePath(root.left, new StringBuilder(sb).append("->"));
        binaryTreePath(root.right, new StringBuilder(sb).append("->"));
    }

    // bfs
    public List<String> binaryTreePaths_bfs(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null) return paths;

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<StringBuilder> pathQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        pathQueue.offer(new StringBuilder().append(root.val));

        StringBuilder sb;
        while (!nodeQueue.isEmpty()) {
            root = nodeQueue.poll();
            sb = pathQueue.poll();

            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
            }

            if (root.left != null) {
                nodeQueue.offer(root.left);
                pathQueue.offer(new StringBuilder(sb).append("->").append(root.left.val));
            }
            if (root.right != null) {
                nodeQueue.offer(root.right);
                pathQueue.offer(new StringBuilder(sb).append("->").append(root.right.val));
            }
        }
        return paths;
    }
}
