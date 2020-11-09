package com.yb.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class P407 {

    /**
     * 407. 接雨水 II<br>
     * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     */
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m < 3 || n < 3) return 0;
        int[][] rain = new int[m][n];

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < m - 1; ++i) {
            queue.offer(i * n);
            bfs(queue, rain, heightMap);
            queue.offer(i * n + n - 1);
            bfs(queue, rain, heightMap);
        }

        for (int i = 2; i < n - 1; ++i) {
            queue.offer(i);
            bfs(queue, rain, heightMap);
            queue.offer(n * (m - 1) + i);
            bfs(queue, rain, heightMap);
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rain[i][j] == 0) continue;
                res += rain[i][j];
            }
        }
        return res;
    }

    private void bfs(Queue<Integer> queue, int[][] rain, int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        int pos = queue.poll();
        int x = pos / n;
        int y = pos % n;
        int src = heightMap[x][y];

        if (x == 0) queue.offer(pos + n);
        else if (x == n - 1) queue.offer(pos - n);
        if (y == 0) queue.offer(pos + 1);
        else if (y == m - 1) queue.offer(pos - 1);

        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            pos = queue.poll();
            x = pos / n;
            y = pos % n;
            if (rain[x][y] != 0 && rain[x][y] < heightMap[x][y] - src) continue;

            if (rain[x][y] == 0) rain[x][y] = src - heightMap[x][y];
            else rain[x][y] = Math.min(rain[x][y], src - heightMap[x][y]);

            visited[x][y] = true;

            if (x - 1 > 0 && !visited[x - 1][y] && heightMap[x - 1][y] <= src) queue.offer(n * (x - 1) + y);
            if (y - 1 > 0 && !visited[x][y - 1] && heightMap[x][y - 1] <= src) queue.offer(n * x + y - 1);
            if (x + 1 < m - 1 && !visited[x + 1][y] && heightMap[x + 1][y] <= src) queue.offer(n * (x + 1) + y);
            if (y + 1 < n - 1 && !visited[x][y + 1] && heightMap[x][y + 1] <= src) queue.offer(n * x + y + 1);
        }
    }
}
