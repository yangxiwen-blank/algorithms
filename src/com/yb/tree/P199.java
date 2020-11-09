package com.yb.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P199 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        // dfs(root,0);
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < size; ++i) {
                cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(cur.val);
        }
        return res;
    }

    private void dfs(TreeNode root, int lvl) {
        if (root == null) return;
        if (res.size() == lvl) res.add(root.val);
        else res.set(lvl, root.val);
        dfs(root.left, lvl + 1);
        dfs(root.right, lvl + 1);
    }
}
