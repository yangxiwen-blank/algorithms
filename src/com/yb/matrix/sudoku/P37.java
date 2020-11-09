package com.yb.matrix.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P37 {

    /**
     * 37. 解数独
     * 编写一个程序，通过已填充的空格来解决数独问题。
     * 一个数独的解法需遵循如下规则：
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 空白格用 '.' 表示。
     */
    public boolean solveSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] grids = new int[9][10];
        int count = 0;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') continue;
                int gNum = i / 3 * 3 + j / 3;
                rows[i][c - '0'] = cols[j][c - '0'] = grids[gNum][c - '0'] = 1;
                ++rows[i][0];
                ++cols[j][0];
                ++grids[gNum][0];

                ++count;
            }
        }
        int tmp = 1;
        while (count < 81 || tmp != 0) {
            if (tmp != 0) tmp = 0;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    char c = board[i][j];
                    if (c != '.') continue;
                    int gNum = i / 3 * 3 + j / 3;

                    int blockCount = 0;
                    Set<Integer> set = new HashSet<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
                    for (int k = 1; k <= 9; ++k) {
                        if (rows[i][k] == 1) set.remove(k);
                        if (cols[j][k] == 1) set.remove(k);
                        if (grids[gNum][k] == 1) set.remove(k);
                    }
                    System.out.println("i: " + i + " j:" + j + " size:" + set.size());
                    if (set.size() > 1) continue;
                    int cur = 0;
                    for (int cc : set) {
                        cur = cc;
                    }
                    System.out.println("i: " + i + " j:" + j + " cur:" + cur);
                    board[i][j] = (char) ('0' + cur);
                    rows[i][cur] = cols[j][cur] = grids[gNum][cur] = 1;
                    ++rows[i][0];
                    ++cols[j][0];
                    ++grids[gNum][0];
                    ++tmp;
                }
            }
            count += tmp;
        }
        return false;
    }
}
