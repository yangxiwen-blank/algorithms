package com.yb.bfs;

import java.util.*;

public class P417 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 417. 太平洋大西洋水流问题<br>
     * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。<br>
     * “太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。<br>
     * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。<br>
     * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。<br>
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;

        //太平洋
        boolean[][] grid = new boolean[m][n];
        //大西洋
        boolean[][] grid1 = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> queue1 = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            grid[0][i] = true;
            queue.offer(new int[]{0, i});
            grid1[m - 1][i] = true;
            queue1.offer(new int[]{m - 1, i});
        }
        for (int i = 0; i < m; ++i) {
            grid[i][0] = true;
            queue.offer(new int[]{i, 0});
            grid1[i][n - 1] = true;
            queue1.offer(new int[]{i, n - 1});
        }
        bfs(grid, queue, matrix);
        bfs(grid1, queue1, matrix);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] && grid1[i][j])
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return res;
    }

    private void bfs(boolean[][] grid, Queue<int[]> queue, int[][] matrix) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int nr = pos[0] + dir[0];
                int nc = pos[1] + dir[1];
                if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length
                        && matrix[pos[0]][pos[1]] <= matrix[nr][nc] && !grid[nr][nc]) {
                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = true;

                }
            }
        }
    }
}
