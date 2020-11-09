package com.yb.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class P1368 {
    /**
     * 1368. 使网格图至少有一条有效路径的最小代价<br>
     * 给你一个 m x n 的网格图 grid 。 <br>grid 中每个格子都有一个数字，对应着从该格子出发下一步走的方向。 <br>grid[i][j] 中的数字可能为以下几种情况：<br>
     * 1 ，下一步往右走，也就是你会从 grid[i][j] 走到 grid[i][j + 1]<br>
     * 2 ，下一步往左走，也就是你会从 grid[i][j] 走到 grid[i][j - 1]<br>
     * 3 ，下一步往下走，也就是你会从 grid[i][j] 走到 grid[i + 1][j]<br>
     * 4 ，下一步往上走，也就是你会从 grid[i][j] 走到 grid[i - 1][j]<br>
     * 注意网格图中可能会有 无效数字 ，因为它们可能指向 grid 以外的区域。<br>
     * 一开始，你会从最左上角的格子 (0,0) 出发。<br>我们定义一条 有效路径 为从格子 (0,0) 出发，每一步都顺着数字对应方向走，最终在最右下角的格子 (m - 1, n - 1) 结束的路径。<br>有效路径 不需要是最短路径 。
     * 你可以花费 cost = 1 的代价修改一个格子中的数字，但每个格子中的数字 只能修改一次 。<br>
     * 请你返回让网格图至少有一条有效路径的最小代价。<br>
     */
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        int res = 0;
        Queue<int[]> queue = new LinkedList<>();

//        if (grid[0][0] == 1)
//            for (int i = 0; i < n; ++i) {
//                queue.offer(new int[]{0, i});
//            }
//        else if (grid[0][0] == 3)
//            for (int i = 0; i < m; ++i) {
//                queue.offer(new int[]{i, 0});
//            }
//        else
        int x = 0, y = 0;
        while (x >= 0 && y >= 0 && x < m && y < n) {
//            queue.offer(new int[]{x, y});
            if (visited[x][y] != 0) break;
            visited[x][y] = 1;
            if (grid[x][y] == 1) queue.offer(new int[]{x, y++});
            else if (grid[x][y] == 2) queue.offer(new int[]{x, y--});
            else if (grid[x][y] == 3) queue.offer(new int[]{x++, y});
            else queue.offer(new int[]{x--, y});
        }
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; ++i) {

            }
        }
        return res;
    }
}
