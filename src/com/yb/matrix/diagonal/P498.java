package com.yb.matrix.diagonal;

public class P498 {
    int[] dirsup = {-1, 1};
    int[] dirsdw = {1, -1};

    /**
     * 498. 对角线遍历
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        int r = matrix.length;
        int c = matrix[0].length;

        int totle = r * c;
        int[] res = new int[totle];

        boolean upOrDown = true;
        int m = 0, n = 0;

        int count = 0;

        int[] dir = null;
        while (count < totle) {
            dir = upOrDown ? dirsup : dirsdw;
            while (m >= 0 && m < r && n >= 0 && n < c) {
                res[count++] = matrix[m][n];
                m += dir[0];
                n += dir[1];
            }
            if (n == c) {
                --n;
                m += 2;
            }
            if (m == r) {
                --m;
                n += 2;
            }
            if (m < 0) m = 0;
            if (n < 0) n = 0;
            upOrDown = !upOrDown;
        }

//        while (m < r && n < c) {
//            dir = turn ? dirs1 : dirs2;
//
//            while (m >= 0 && m < r && n >= 0 && n < c) {
//                m += dir[0];
//                n += dir[1];
//                res[count++] = matrix[m][n];
//            }
//            if (m < 0) m = 0;
//            if (n < 0) n = 0;
//
//        }
        for (int i = 0; i < r + c; i++) {
            while (m >= 0 && m < r && n >= 0 && n < c) {
                if (upOrDown) {
                    res[count++] = matrix[m][i - m];
                    ++m;
                } else {
                    res[count++] = matrix[i - n][n];
                    ++n;
                }

            }
            upOrDown = !upOrDown;
        }

//        for (int i = 0; i < r; i++) {
//
//        }
//
//        for (int i = 0; i < c; i++) {
//
//        }

        return res;
    }
}
