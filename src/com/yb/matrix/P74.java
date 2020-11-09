package com.yb.matrix;

public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0, len = matrix.length; i < len; ++i) {
            int j = matrix[0].length - 1;
            if (target > matrix[i][j]) continue;
            for (int k = 0; k <= j; ++k) {
                if (target == matrix[i][k]) return true;
            }
        }
        return false;
    }
}
