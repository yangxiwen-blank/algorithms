package com.yb.bfs;

import java.util.*;

public class P310 {

    /**
     * 310. 最小高度树<br>
     * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。<br>
     * 图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。<br>
     * 给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。<br>
     * <br>
     * 格式<br>
     * 该图包含 n 个节点，标记为 0 到 n - 1。<br>
     * 给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。<br>
     * 你可以假设没有重复的边会出现在 edges 中。<br>
     * 由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。<br>
     * <br>
     * 说明:<br>
     * 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。<br>
     * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。<br>
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //暴力，超时
        //List<Integer> res = new ArrayList<>();
        //Map<Integer, Set<Integer>> map = getEdgeMap(edges);
        //boolean[] visited = null;
        //int[] sizes = new int[n];
        //Queue<Integer> queue = new ArrayDeque<>();
        //int min = n;
        //for (int i = 0; i < n; ++i) {
        //    visited = new boolean[n];
        //    queue.offer(i);
        //    int count = sizes[i];
        //    while (!queue.isEmpty()) {
        //        int size = queue.size();
        //        for (int j = 0; j < size; ++j) {
        //            int cur = queue.poll();
        //            visited[cur] = true;
        //
        //            if (!map.containsKey(cur)) continue;
        //            Set<Integer> set = map.get(cur);
        //            for (int target : set) {
        //                if (!visited[target]) queue.offer(target);
        //            }
        //        }
        //        count++;
        //        if (count > min) queue.clear();
        //    }
        //    sizes[i] = count;
        //    min = Math.min(min, count);
        //}
        //for (int i = 0; i < n; ++i) {
        //    if (sizes[i] == min) res.add(i);
        //}
        List<Integer> res = null;
        if (n < 2) {
            res = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                res.add(i);
            }
            return res;
        }
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> map = getEdgeMap(edges, degree);

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) queue.offer(i);
        }
        Set<Integer> set = null;
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            for (int i = 0, len = queue.size(); i < len; ++i) {
                int cur = queue.poll();
                res.add(cur);
                set = map.get(cur);
                for (int leaf : set) {
                    --degree[leaf];
                    if (degree[leaf] == 1) queue.offer(leaf);
                }
            }
        }
        return res;
    }

    private Map<Integer, Set<Integer>> getEdgeMap(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> set0 = map.getOrDefault(edge[0], new HashSet<>());
            set0.add(edge[1]);
            map.put(edge[0], set0);
            Set<Integer> set1 = map.getOrDefault(edge[1], new HashSet<>());
            set1.add(edge[0]);
            map.put(edge[1], set1);
        }
        return map;
    }

    private Map<Integer, Set<Integer>> getEdgeMap(int[][] edges, int[] degree) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            ++degree[edge[0]];
            Set<Integer> set0 = map.getOrDefault(edge[0], new HashSet<>());
            set0.add(edge[1]);
            map.put(edge[0], set0);

            ++degree[edge[1]];
            Set<Integer> set1 = map.getOrDefault(edge[1], new HashSet<>());
            set1.add(edge[0]);
            map.put(edge[1], set1);
        }
        return map;
    }

}
