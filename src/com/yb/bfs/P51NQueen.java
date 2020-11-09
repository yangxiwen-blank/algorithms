package com.yb.bfs;

import java.util.List;

/**
 * 51. N皇后<br>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。<br>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。<br>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。<br>
 * <p>
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。<br>
 * 皇后只做一件事，那就是“吃子”。<br>
 * 当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。<br>
 * 当然，她<u>横、竖、斜都可走一到七步</u>，可进可退。
 */
public class P51NQueen {
    int[][] dirs = {{-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {0, 1}, {0, -1}, {1, -1}, {-1, 1}};

    int gn = 0;
    int res52 = 0;

    public List<List<String>> solveNQueens(int n) {
        int[][] loc = new int[n][n];
        gn = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                addQueen(loc, i, j, 1);
            }
        }
        return null;
    }

    private void addQueen(int[][] loc, int r, int c, int num) {

        loc[r][c] = 1;
        for (int[] dir : dirs) {
            int nr = r;
            int nc = c;
            for (int i = 0; i < 7; i++) {
                r += dir[0];
                c += dir[1];
                if (nr >= 0 && nr < gn && nc >= 0 && nc < gn && loc[nr][nc] == 0) ;
            }
        }
        for (int i = r; i < gn; i++) {
            for (int j = 0; j < gn; j++) {
                if (loc[i][j] == 0)
                    addQueen(loc, i, j, num + 1);
            }
        }
    }

    public int totalNQueens(int n) {
        boolean[][] loc = new boolean[n][n];
        backtrack(loc, n);
        return res52;
    }

    private void backtrack(boolean[][] loc, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                loc[i][j] = true;

                loc[i][j] = false;
            }
        }
    }
}
