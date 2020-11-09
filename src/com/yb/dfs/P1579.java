package com.yb.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class P1579 {

    /**
     * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
     * <p>
     * 类型 1：只能由 Alice 遍历。
     * 类型 2：只能由 Bob 遍历。
     * 类型 3：Alice 和 Bob 都可以遍历。
     * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
     * <p>
     * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int res = 0;
        int len = edges.length;
        int[][] alice = new int[len][3];
        int[][] bob = new int[len][3];
        int[][] all = new int[len][3];
        boolean[] visit = new boolean[n + 1];
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return o1[1] == o2[1] ? o2[0]-o1[0] : o1[1] - o2[1];
                return o1[1] - o2[1];
//                return o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        int ca = 0, cb = 0, cc = 0;
        for (int[] edge : edges) {
            if (edge[0] == 1) alice[ca++] = edge;
            else if (edge[0] == 2) bob[cb++] = edge;
            else all[cc++] = edge;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        visit[all[0][1]] = true;
        visit[all[0][2]] = true;
        for (int i = 1; i < ca; ++i) {
            if (!visit[all[i][1]] && !visit[all[i][2]]) {
                queue.offer(all[i][1]);
                queue.offer(all[i][2]);
                visit[all[i][1]] = true;
                visit[all[i][2]] = true;
            } else if (visit[all[i][1]] && visit[all[i][2]]) ++res;
            else {
                visit[all[i][1]] = true;
                visit[all[i][2]] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) queue.offer(all[i][1]);
            visit[i] = false;
        }
        if (queue.size() == 0) {
            return res + ca + cb;
        }

        visit[alice[0][1]] = true;
        visit[alice[0][2]] = true;
//        queue.c
        for (int i = 1; i < ca; ++i) {
            if (!visit[alice[i][1]] && !visit[alice[i][2]])
                return -1;
            else if (visit[alice[i][1]] && visit[alice[i][2]]) ++res;
            else {
                visit[alice[i][1]] = true;
                visit[alice[i][2]] = true;
            }
        }
        boolean can = true;
        for (int i = 1; i <= n; i++) {
            can = can & visit[i];
        }

        Arrays.fill(visit, false);
        visit[bob[0][1]] = true;
        visit[bob[0][2]] = true;
        for (int i = 1; i < cb; ++i) {
            if (!visit[bob[i][1]] && !visit[bob[i][2]]) return -1;
            else if (visit[bob[i][1]] && visit[bob[i][2]]) {
                if (bob[i][0] != 3) ++res;
            } else {
                visit[bob[i][1]] = true;
                visit[bob[i][2]] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            can = can & visit[i];
        }
        return can ? res : -1;
    }
}
