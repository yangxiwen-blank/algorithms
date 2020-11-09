package com.yb.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contest212 {
    int res = 0, r = 0, c = 0;

    public static void main(String[] args) {
        new Contest212().slowestKey(new int[]{9, 29, 49, 50}, "abcd");
        new Contest212().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5});
        new Contest212().minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
        System.out.println();
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int len = releaseTimes.length;
        int max = 0;
        char res = 'a';
        for (int i = len - 1; i >= 0; --i) {
            if (i > 0)
                releaseTimes[i] -= releaseTimes[i - 1];
            if (releaseTimes[i] > max || (releaseTimes[i] == max && keysPressed.charAt(i) > res)) {
                res = keysPressed.charAt(i);
                max = releaseTimes[i];
            }
        }
        return res;
    }

    public int minimumEffortPath(int[][] heights) {
        res = Integer.MAX_VALUE;
        r = heights.length;
        c = heights[0].length;
        int[][] chaArray = new int[r][c];
        boolean[][] visited = new boolean[r][c];

        dfs(heights, chaArray, visited, 0, 0, 0);
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{0, 0, 0});
//        while (!queue.isEmpty()) {
//            for (int i = 0, len = queue.size(); i < len; ++i) {
//                int[] cur = queue.poll();
//                if (cur[0] == r - 1 && cur[1] == c - 1) {
//                    res = Math.min(res,cur[2]);
//                }
//                if (cur[0] + 1 < r) {
//                    int cha = Math.abs(heights[cur[0]][cur[1]] - heights[cur[0] + 1][cur[1]]);
//                    queue.offer(new int[]{cur[0] + 1, cur[1], Math.max(cur[2], cha)});
//                }
//                if (cur[1] + 1 < c) {
//                    int cha = Math.abs(heights[cur[0]][cur[1]] - heights[cur[0]][cur[1] + 1]);
//                    queue.offer(new int[]{cur[0], cur[1] + 1, Math.max(cur[2], cha)});
//                }
//            }
//        }
        return res;
    }

    private void dfs(int[][] heights, int[][] chaArray, boolean[][] visited, int r0, int c0, int cha) {
        if (r0 == r - 1 && c0 == c - 1) {
            res = Math.min(res, cha);
            return;
        }
        chaArray[r0][c0] = res;
        visited[r0][c0] = true;
        if (r0 + 1 < r && !visited[r0 + 1][c0]) {
            int cha2 = Math.abs(heights[r0][c0] - heights[r0 + 1][c0]);
            if (chaArray[r0 + 1][c0] >= cha2)
                dfs(heights, chaArray, visited, r0 + 1, c0, Math.max(cha, cha2));
        }
        if (c0 + 1 < c && !visited[r0][c0 + 1]) {
            int cha2 = Math.abs(heights[r0][c0] - heights[r0][c0 + 1]);
            if (chaArray[r0][c0 + 1] >= cha2)
                dfs(heights, chaArray, visited, r0, c0 + 1, Math.max(cha, cha2));
        }
        if (r0 - 1 >= 0 && !visited[r0 - 1][c0]) {
            int cha2 = Math.abs(heights[r0][c0] - heights[r0 - 1][c0]);
            if (chaArray[r0 - 1][c0] >= cha2)
                dfs(heights, chaArray, visited, r0 - 1, c0, Math.max(cha, cha2));
        }
        if (c0 - 1 >= 0 && !visited[r0][c0 - 1]) {
            int cha2 = Math.abs(heights[r0][c0] - heights[r0][c0 - 1]);
            if (chaArray[r0][c0 - 1] >= cha2)
                dfs(heights, chaArray, visited, r0, c0 - 1, Math.max(cha, cha2));
        }

        visited[r0][c0] = false;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int[] sub = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(sub);
            if (r[i] - l[i] < 2) {
                res.add(true);
                continue;
            }
            int ms = sub[1] - sub[0];
            for (int j = 2; j <= r[i] - l[i]; ++j) {
                if (sub[j] - sub[j - 1] != ms) {
                    res.add(false);
                    ms = -1;
                    continue;
                }
            }
            if (ms >= 0)
                res.add(true);
        }
        return res;
    }
}
