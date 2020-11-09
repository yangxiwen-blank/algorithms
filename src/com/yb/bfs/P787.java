package com.yb.bfs;

import java.util.*;

public class P787 {
    public static void main(String[] args) {
        System.out.println(new P787().findCheapestPrice(10, new int[][]
                {{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}}, 6, 0, 7));
    }

    /**
     * 787. K 站中转内最便宜的航班<br>
     * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。<br>
     * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。<br>
     * 如果没有这样的路线，则输出 -1。
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<int[]>());
        }
        for (int[] flight : flights) {
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
//        Queue<int[]> queue = new ArrayDeque<>();
//        for (int[] tar : map.get(src)) {
//            queue.offer(tar);
//        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(src);

        int[][] res = new int[K + 2][n];
        for (int[] r : res) Arrays.fill(r, Integer.MAX_VALUE);
        res[K + 1][src] = 0;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty() && K >= 0) {
            for (int i = 0, len = queue.size(); i < len; ++i) {
//                int[] cur = queue.poll();
//
//                if (cur[0] == dst) {
////                    res = Math.min(res, cur);
//                    continue;
//                }
////                res[cur[0]] = Math.min(res[cur[0]], cur[1]);
//                for (int[] tar : map.get(cur[0])) {
//                    if (tar == null || res[tar[0]] <= res[cur[0]] + tar[1]) continue;
////                    tar[1] += cur[1];
//                    tar[1] += cur[1];
//                    queue.offer(tar);
//                }
                int cur = queue.poll();
                if (cur == dst) {
                    min = Math.min(min, res[K + 1][dst]);
                    continue;
                }
                for (int[] tar : map.get(cur)) {
                    if (tar == null || res[K][tar[0]] <= res[K + 1][cur] + tar[1]) continue;
                    res[K][tar[0]] = res[K + 1][cur] + tar[1];
                    queue.offer(tar[0]);
                }
            }
            K--;
        }
        min = Math.min(min, res[0][dst]);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
