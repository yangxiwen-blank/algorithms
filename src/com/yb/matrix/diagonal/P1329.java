package com.yb.matrix.diagonal;

import java.util.PriorityQueue;

public class P1329 {
    public static void main(String[] args) {
        diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}});
    }

    /**
     * 1329. 将矩阵按对角线排序<br>
     * 给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
     */
    public static int[][] diagonalSort(int[][] mat) {
        if (mat == null || mat.length <= 1 || mat[0].length <= 1) return mat;
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            swap(mat, i, 0, queue);
        }
        for (int j = 1; j < n; j++) {
            swap(mat, 0, j, queue);
        }
        return mat;
    }

    private static void swap(int[][] mat, int i, int j, PriorityQueue<Integer> queue) {
//        if (mat[i][j] >= mat[i - 1][j - 1]) return;
//
//        int tmp = mat[i][j];
//        mat[i][j] = mat[i - 1][j - 1];
//        mat[i - 1][j - 1] = tmp;
        int x = i;
        int y = j;
        while (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) {
            queue.offer(mat[x][y]);
            ++x;
            ++y;
        }

        x = i;
        y = j;
        while (queue.size() > 0) {
            mat[x++][y++] = queue.poll();
        }
    }
}
