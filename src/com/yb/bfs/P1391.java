package com.yb.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class P1391 {
    int[][] dir1 = new int[][]{{0, 1}, {0, -1}};
    int[][] dir2 = new int[][]{{1, 0}, {-1, 0}};
    int[][] dir3 = new int[][]{{0, -1}, {1, 0}};
    int[][] dir4 = new int[][]{{0, 1}, {1, 0}};
    int[][] dir5 = new int[][]{{-1, 0}, {0, -1}};
    int[][] dir6 = new int[][]{{0, 1}, {0, -1}};

    /**
     * 1391. 检查网格中是否存在有效路径<br>
     * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：<br>
     * 1 表示连接左单元格和右单元格的街道。<br>
     * 2 表示连接上单元格和下单元格的街道。<br>
     * 3 表示连接左单元格和下单元格的街道。<br>
     * 4 表示连接右单元格和下单元格的街道。<br>
     * 5 表示连接左单元格和上单元格的街道。<br>
     * 6 表示连接右单元格和上单元格的街道。<br>
     * 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。<br>
     * 该路径必须只沿着街道走。<br>
     * 注意：你 不能 变更街道。<br>
     * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
     */
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (cur[0] == m - 1 && cur[1] == n - 1) return true;
            if (visited[x][y]) continue;
            visited[x][y] = true;
//            for (int[] dir : getdir(grid[x][y])) {
//                int x = cur[0] + dir[0];
//                int y = cur[1] + dir[1];
//                if (x >= 0 && y >= 0 && x < m && y < n) queue.offer(new int[]{x, y});
//            }
            int v = grid[x][y];
            // 左
            if (canLeft(grid, x, y) && canRight(grid, x, y - 1)) queue.offer(new int[]{x, y - 1});
            //右
            if (canRight(grid, x, y) && canLeft(grid, x, y + 1)) queue.offer(new int[]{x, y + 1});
            //上
            if (canUp(grid, x, y) && canDown(grid, x - 1, y)) queue.offer(new int[]{x - 1, y});
            //下
            if (canDown(grid, x, y) && canUp(grid, x + 1, y)) queue.offer(new int[]{x + 1, y});
        }
        return false;
    }

    private boolean canLeft(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
        int v = grid[x][y];
        if (v == 1 || v == 3 || v == 5) return true;
        else return false;
    }

    private boolean canRight(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
        int v = grid[x][y];
        if (v == 1 || v == 4 || v == 6) return true;
        else return false;
    }

    private boolean canUp(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
        int v = grid[x][y];
        if (v == 2 || v == 5 || v == 6) return true;
        else return false;
    }

    private boolean canDown(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
        int v = grid[x][y];
        if (v == 2 || v == 3 || v == 4) return true;
        else return false;
    }

    private int[][] getdir(int i) {
        if (i == 1) return dir1;
        else if (i == 2) return dir2;
        else if (i == 3) return dir3;
        else if (i == 4) return dir4;
        else if (i == 5) return dir5;
        else return dir6;
    }
}
