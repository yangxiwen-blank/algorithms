package com.yb.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class P79 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean valid = false;

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = null;

        char[] chars = word.toCharArray();
        for (int i = 0; i < r && !valid; ++i) {
            for (int j = 0; j < c && !valid; ++j) {
                if (board[i][j] == chars[0]) {
                    visited = new boolean[r][c];
                    if (dfs(board, i, j, visited, chars, 0)) {
                        return true;
                    }

                    return bfs(board, i, j, visited, chars, 0);
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, int i, int j, boolean[][] visited, char[] chars, int cur) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, cur});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
//                    if (dfs(board, nr, nc, visited, chars, cur + 1)) {
//                        res = true;
                        break;
//                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] visited, char[] chars, int cur) {
        if (visited[i][j] || board[i][j] != chars[cur]) return false;
        if (cur == chars.length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if (dfs(board, nr, nc, visited, chars, cur + 1)) {
                    res = true;
                    break;
                }
            }
        }
        // 错误路线重置visited状态
        visited[i][j] = false;
        return res;
    }
}
