package com.yb.matrix;

import java.util.ArrayList;
import java.util.List;

public class P1222 {
    public int[][] dir8 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    /**
     * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
     * 「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。
     * 「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。
     * 请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。
     */
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] grid = new int[8][8];

        for (int[] queen : queens) {
            grid[queen[0]][queen[1]] = 1;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = null;
        for (int[] dir : dir8) {
            for (int i = 1; i < 8; i++) {
                int nx = king[0] + dir[0] * i;
                int ny = king[1] + dir[1] * i;

                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) break;

                if (grid[nx][ny] == 1) {
                    tmp = new ArrayList<>();
                    tmp.add(nx);
                    tmp.add(ny);
                    res.add(tmp);
                    break;
                }
            }
        }

        return res;
    }
}
