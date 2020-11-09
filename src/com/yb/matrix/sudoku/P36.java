package com.yb.matrix.sudoku;

public class P36 {
    /**
     * 36. 有效的数独
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 上图是一个部分填充的有效的数独。
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * <p>
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     */
    public boolean isValidSudoku(char[][] board) {
//        Set<Character> row = null;
//        Set<Character> col = null;
//        List<Set<Character>> grid = new ArrayList<>();
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] grids = new int[9][10];
        for (int i = 0; i < 9; ++i) {
//            row = new HashSet<>();
//            col = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') continue;
//                char cc = board[i][j];
//                if (rc != '.' && !row.contains(rc)) row.add(rc);
//                else return false;
//                if (cc != '.' && !col.contains(cc)) col.add(cc);
//                else return false;
                if (rows[i][c - '0'] != 0) return false;
                else ++rows[i][c - '0'];
                if (cols[j][c - '0'] != 0) return false;
                else ++cols[j][c - '0'];
                int gNum = i / 3 * 3 + j / 3;
                if (grids[gNum][c - '0'] != 0) return false;
                else ++grids[gNum][c - '0'];

            }
        }

        return true;
    }
}
