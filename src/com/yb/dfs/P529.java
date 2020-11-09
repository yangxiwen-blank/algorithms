package com.yb.dfs;

public class P529 {
    public int[][] dir8 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    char[] blocks = {'B', '1', '2', '3', '4', '5', '6', '7', '8'};

    /**
     * 529. 扫雷游戏
     * 让我们一起来玩扫雷游戏！
     * 给定一个代表游戏板的二维字符矩阵。
     * 'M' 代表一个未挖出的地雷，
     * 'E' 代表一个未挖出的空方块，
     * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
     * 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
     * 'X' 则表示一个已挖出的地雷。
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
     * <p>
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        char c = board[click[0]][click[1]];
        if (c == 'M') board[click[0]][click[1]] = 'X';
        else if (c == 'E') {
            updateBoard(board, click[0], click[1]);
        }
        return board;
    }

    private void updateBoard(char[][] board, int r, int c) {
        int count = 0;
        for (int[] dir : dir8) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'M') count++;
        }
        board[r][c] = blocks[count];

        if (count == 0) {
            for (int[] dir : dir8) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'E')
                    updateBoard(board, nr, nc);
            }
        }
    }
}
