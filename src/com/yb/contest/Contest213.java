package com.yb.contest;

import java.util.*;

public class Contest213 {
    public static void main(String[] args) {
        Contest213 contest213 = new Contest213();
        for (int i = 1; i < 3; ++i) {
            System.out.println(contest213.countVowelStrings(i));
//            System.out.println((i + 4) * (i + 3) * (i + 2) * (i + 1) / 24);
        }
        System.out.println(contest213.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        System.out.println(contest213.canFormArray(new int[]{91, 4, 64, 60, 78}, new int[][]{{78}, {4, 64}, {60}, {91}}));
    }

    /**
     * 1640. 能否连接形成数组<br>
     * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。<br>
     * 另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。<br>
     * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。<br>
     * 但是，不允许 对每个数组 pieces[i] 中的整数重新排序。<br>
     * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
//        int len = pieces.length;
//        int pos = -1, count = 0;
//        for (int i = 0; i < len; ++i) {
//            if (pieces[i][0] == arr[0]) {
//                pos = i;
//            }
//            count += pieces[i].length;
//        }
//        int l = arr.length;
//        if (pos < 0 || count != l) return false;
//
//        int tmp = pos;
//        boolean res = true;
//        for (int i = 0; i < l && res; ++i) {
//            int[] piece = pieces[tmp++];
//            if (tmp == len) tmp = 0;
//            for (int j = 0, le = piece.length; j < le; ++j) {
//                if (arr[i++] != piece[j]) {
//                    res = false;
//                    break;
//                }
//            }
//        }
//        boolean res2 = true;
//        tmp = pos;
//        for (int i = 0; i < l && res2; ++i) {
//            int[] piece = pieces[tmp--];
//            if (tmp == 0) tmp = len - 1;
//            for (int j = 0, le = piece.length; j < le; ++j) {
//                if (arr[i++] != piece[j]) {
//                    res2 = false;
//                    break;
//                }
//            }
//        }
//        return res || res2;
        int len = arr.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        for (int i = 0; i < len; ++i) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] piece = map.get(arr[i]);
            int l = piece.length;
            for (int j = 0; j < l && i + j < len; ++j) {
                if (piece[j] != arr[i + j]) return false;
            }
            i += l - 1;
        }
        return true;
    }

    /**
     * 5555. 统计字典序元音字符串的数目<br>
     * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。<br>
     * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
     */
    public int countVowelStrings(int n) {
        //(i + 4) * (i + 3) * (i + 2) * (i + 1) / 24
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);
        int res = 5;
        for (int i = 1; i < n; ++i) {
            res = 0;
            for (int j = 0; j < 5; ++j) {
                res += dp[i - 1][j];
                dp[i][j] = res;
            }
        }
        res = 0;
        for (int j = 0; j < 5; ++j) {
            res += dp[n - 1][j];
        }
        return res;
    }

    /**
     * 5556. 可以到达的最远建筑<br>
     * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。<br>
     * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。<br>
     * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：<br>
     * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块<br>
     * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块<br>
     * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。<br>
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
//        int[][] dp = new int[n][2];
//        int[][] dp2 = new int[n][2];
//        dp[0][0] = bricks;
//        dp[0][1] = ladders;
//        dp2[0][0] = bricks;
//        dp2[0][1] = ladders;

        int n = heights.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 1; i < n; ++i) {
            if (heights[i] <= heights[i - 1]) {
            } else {
                int m = heights[i] - heights[i - 1];
                bricks -= m;
                queue.offer(m);
                if (bricks >= 0) continue;
                else if (ladders > 0 && queue.size() > 0) {
                    bricks += queue.poll();
                    ladders -= 1;
                } else return i - 1;
            }
        }

        return n - 1;
    }

    /**
     * 5600. 第 K 条最小指令<br>
     * Bob 站在单元格 (0, 0) ，想要前往目的地 destination ：(row, column) 。<br>
     * 他只能向 右 或向 下 走。你可以为 Bob 提供导航 指令 来帮助他到达目的地 destination 。<br>
     * 指令 用字符串表示，其中每个字符：<br>
     * 'H' ，意味着水平向右移动<br>
     * 'V' ，意味着竖直向下移动<br>
     * 能够为 Bob 导航到目的地 destination 的指令可以有多种，<br>
     * 例如，如果目的地 destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。<br>
     * 然而，Bob 很挑剔。<br>
     * 因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。<br>
     * k  的编号 从 1 开始 。<br>
     * 给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地 destination 导航的 按字典序排列后的第 k 条最小指令 。
     */
    public String kthSmallestPath(int[] destination, int k) {
        int len = destination[0] + destination[1];
        char[] res = new char[len];
        // 暴力超时
        // for (int i = 0; i < len; ++i) {
        //     if (i < destination[1]) res[i] = 'H';
        //     else res[i] = 'V';
        // }
        //
        // for (int i = 1; i < k; ++i) {
        //     for (int j = len - 2; j >= 0; --j) {
        //         if (res[j] == 'H' && res[j + 1] == 'V') {
        //             swap(res, j, j + 1);
        //             break;
        //         }
        //     }
        // }
        int[][] dp = new int[len][destination[0]];
        return new String(res);
    }

    private void swap(char[] nums, int index1, int index2) {
        char temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

        // Character.MAX_VALUE
    }
}
