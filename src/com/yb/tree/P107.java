package com.yb.tree;

import java.util.*;

public class P107 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        // bfs
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tn = queue.pollLast();
                level.add(tn.val);
                if (tn.left != null) queue.offer(tn.left);
                if (tn.right != null) queue.offer(tn.right);
            }

            res.add(0, level);
        }

        // dfs
        levelOrderBottom(root, 0);
        Collections.reverse(res);
        return res;
    }


    private void levelOrderBottom(TreeNode root, int i) {
        if (root == null) return;

        if (i <= res.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
        } else {
            res.get(i).add(root.val);
        }

        levelOrderBottom(root.left, i + 1);
        levelOrderBottom(root.right, i + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int lvl = 0;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tn = queue.poll();
                if (lvl % 2 == 0) {
                    level.add(0, tn.val);
                    if (tn.right != null) queue.offer(tn.right);
                    if (tn.left != null) queue.offer(tn.left);
                } else {
                    level.add(tn.val);
                    if (tn.left != null) queue.offer(tn.left);
                    if (tn.right != null) queue.offer(tn.right);
                }
            }

            ++lvl;
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        List<Integer> level = null;
        while (!queue.isEmpty()) {
            level = new ArrayList<>();
            for (int i = 0, len = queue.size(); i < len; ++i) {
                Node cur = queue.poll();
                level.add(cur.val);
                if (cur.children == null || cur.children.size() == 0) continue;

                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            res.add(level);
        }

        return res;
    }
}
