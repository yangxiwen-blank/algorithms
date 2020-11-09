package com.yb.matrix;

public class P221 {

    /**
     * 221. 最大正方形
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int r0 = matrix.length;
        int c0 = matrix[0].length;

        int res = 0;
        int[][] dp = new int[r0 + 1][c0 + 1];
        int x, y;
        for (int i = 0; i < r0; i++) {
            for (int j = 0; j < c0; j++) {
                x = i + 1;
                y = j + 1;
                if (matrix[i][j] == '0') {
                    dp[x][y] = 0;
                    continue;
                }
                dp[x][y] = Math.min(Math.min(dp[x][j], dp[i][y]), dp[i][j]) + 1;
                res = Math.max(res, dp[x][y]);
            }
        }
        return res * res;
    }
}
