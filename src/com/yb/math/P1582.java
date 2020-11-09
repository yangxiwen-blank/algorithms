package com.yb.math;

public class P1582 {

    /**
     * 1582. 二进制矩阵中的特殊位置
     * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
     * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
     */
    public int numSpecial(int[][] mat) {
        int res = 0;
        int rs = mat.length;
        int cs = mat[0].length;
        for (int i = 0; i < rs; ++i) {
            int c = 0;
            int pos = 0;
            for (int j = 0; j < cs; ++j) {
                if (mat[i][j] == 1) {
                    ++c;
                    pos = j;
                }
            }
            if (c != 1) continue;
            for (int j = 0; j < rs; ++j) {
                if (j != i && mat[j][pos] == 1) {
                    ++c;
                    break;
                }
            }
            if (c == 1) ++res;
        }
        return res;
    }
}
