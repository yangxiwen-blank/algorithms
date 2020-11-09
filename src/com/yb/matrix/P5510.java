package com.yb.matrix;

public class P5510 {
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
        int len = edges.length;

        int ca = 0, cb = 0;
        int[][] a = new int[len][2];
        int[][] b = new int[len][2];

        for (int[] edge : edges) {
            if (edge[0] != 1) {
                b[cb][0] = edge[1];
                b[cb][1] = edge[2];
            }
            if (edge[0] != 2) {

            }
        }
        return 0;
    }
}
