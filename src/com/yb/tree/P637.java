package com.yb.tree;

import java.util.*;

public class P637 {
    Map<Integer, long[]> map = new LinkedHashMap<>();

    /**
     * 637. 二叉树的层平均值<br>
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     */
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);

//        for (long[] item : map.values()) {
//            res.add((double) item[1] / item[0]);
//        }

        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                sum += cur.val;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(sum / size);
        }
        return res;
    }

    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) queue.offer(left);
                if (right != null) queue.offer(right);
            }
            res.add(sum / size);
        }
        return res;
    }

    private void dfs(TreeNode root, int i) {
        if (root == null) return;
        long[] n = map.getOrDefault(i, new long[2]);

        ++n[0];
        n[1] += root.val;
        map.put(i, n);

        dfs(root.left, i + 1);
        dfs(root.right, i + 1);
    }
}
