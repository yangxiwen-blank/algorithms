package com.yb.matrix;

/**
 * 48. 旋转图像<br>
 * 给定一个 n × n 的二维矩阵表示一个图像。<br>
 * 将图像顺时针旋转 90 度。
 */
public class P48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        if (n <= 1) return;

        int tmp = 0;
        for (int i = 0; i <= n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                tmp = matrix[i][j];

                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = tmp;
            }
        }
    }
}
