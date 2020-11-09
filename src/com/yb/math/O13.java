package com.yb.math;

import java.util.ArrayDeque;
import java.util.Queue;

public class O13 {
    public int[][] dirs = {{1, 0}, {0, 1}};
    int res = 0;

    /**
     * 剑指 Offer 13. 机器人的运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
     * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     */
    public int movingCount(int m, int n, int k) {
        //dfs
        //int[][] visited = new int[m][n];
        //dfs(visited, 0, 0, k);
        //return res;

        //bfs
        int res = 0;
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{0, 0});

        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            visited[x][y] = 1;
            if (count(x, y) <= k) ++res;
            else continue;

            if (x + 1 < visited.length && visited[x + 1][y] == 0) queue.offer(new int[]{x + 1, y});
            if (y + 1 < visited[0].length && visited[x][y + 1] == 0) queue.offer(new int[]{x, y + 1});
        }
        return res;
    }

    private int count(int x, int y) {
        int num = x % 10 + y % 10;
        while (x / 10 > 0) {
            x /= 10;
            num += x % 10;
        }

        while (y / 10 > 0) {
            y /= 10;
            num += y % 10;
        }
        return num;
    }

    private void dfs(int[][] visited, int r, int c, int k) {
        visited[r][c] = 1;
        if (count(r, c) <= k) ++res;
        else return;
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            if (x < visited.length && y < visited[0].length && visited[x][y] == 0) dfs(visited, x, y, k);
        }
    }
}
