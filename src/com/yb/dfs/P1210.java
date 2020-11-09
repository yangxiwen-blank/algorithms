package com.yb.dfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class P1210 {

    int n = 0;

    /**
     * 1210. 穿过迷宫的最少移动次数
     * 你还记得那条风靡全球的贪吃蛇吗？
     * 我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。
     * 蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。
     * 我们用 0 表示空单元格，用 1 表示障碍物。
     * 蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。
     * <p>
     * 每次移动，蛇可以这样走：
     * 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
     * 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
     * 如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
     * 如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。
     * <p>
     * 返回蛇抵达目的地所需的最少移动次数。
     * 如果无法到达目的地，请返回 -1。
     */
    public int minimumMoves(int[][] grid) {
        n = grid.length;
        if (grid[n - 1][n - 1] == 1 || grid[n - 1][n - 2] == 1) return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0, 1, 0});
        int[][] visited = new int[n][n];
        while (queue.size() > 0) {

            int[] pos = queue.poll();
            int x1 = pos[0];
            int y1 = pos[1];
            int x2 = pos[2];
            int y2 = pos[3];
            int count = pos[4];

            int dir = x1 == x2 ? 1 : 2;
            if (visited[x2][y2] == dir) continue;
            visited[x2][y2] = dir;

            if (x1 == n - 1 && x2 == n - 1 && y1 == n - 2 && y2 == n - 1)
                return count;

            System.out.print(count + "  ");
            if (x1 < n - 1 && x2 < n - 1 && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0) {
                // 横向 转纵向
                if (x1 == x2) {
                    queue.offer(new int[]{x1, y1, x2 + 1, y2 - 1, count + 1});
                }
                // 纵平移
                queue.offer(new int[]{x1 + 1, y1, x2 + 1, y2, count + 1});
            }
            if (y1 < n - 1 && y2 < n - 1 && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0) {
                // 纵向 转横向
                if (y1 == y2) {
                    queue.offer(new int[]{x1, y1, x2 - 1, y2 + 1, count + 1});
                }
                // 横平移
                queue.offer(new int[]{x1, y1 + 1, x2, y2 + 1, count + 1});
            }
        }

//        return dfs(grid, 0, 0, 0, 1, false, 0);
        return -1;
    }

    private int dfs(int[][] grid, int x1, int y1, int x2, int y2, boolean turn, int count) {
        if (x1 == n - 1 && x2 == n - 1 && y1 == n - 2 && y2 == n - 1)
            return count;
        if ((y2 == n - 1 || grid[x2][y2 + 1] == 1) && (x2 == n - 1 || grid[x2 + 1][y2] == 1))
            return -2;
//        if (x1 == x2 && y2 < n - 1 && grid[x2][y2 + 1] == 1)// 横向 横平移
//            count = Math.max(count, dfs(grid, x1, y1 + 1, x2, y2 + 1, true, count));
//        if (x2 < n - 1 && grid[x2 + 1][y2] == 1)// 纵向 纵平移
//            count = Math.max(count, dfs(grid, x1 + 1, y1, x2 + 1, y2, false, count));
        int tmp = count;
        int[] hand = new int[4];
        if (x1 < n - 1 && x2 < n - 1 && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0) {
            // 横向 转纵向
            if (!turn && x1 == x2) {
                System.out.print(tmp + "转纵 ");
                hand[0] = dfs(grid, x1, y1, x2 + 1, y2 - 1, true, tmp);
            }
            // 纵平移
            System.out.print(tmp + "下️ ");
            hand[1] = dfs(grid, x1 + 1, y1, x2 + 1, y2, false, tmp);
        }
        if (y1 < n - 1 && y2 < n - 1 && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0) {
            // 纵向 转横向
            if (!turn && y1 == y2) {
                System.out.print(tmp + "转横 ");
                hand[2] = dfs(grid, x1, y1, x2 - 1, y2 + 1, true, tmp);
            }
            // 横平移
            System.out.print(tmp + "右️ ");
            hand[3] = dfs(grid, x1, y1 + 1, x2, y2 + 1, false, tmp);
        }

        for (int h : hand) {
            if (h != 0)
                count = Math.max(-1, h);
        }
        return count + 1;
    }
}
