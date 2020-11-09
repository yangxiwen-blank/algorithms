package com.yb.array;

import java.util.Arrays;

public class P1033 {

    /**
     * 1033. 移动石子直到连续
     * 三枚石子放置在数轴上，位置分别为 a，b，c。
     * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。
     * 从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
     * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
     * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
     */
    public int[] numMovesStones(int a, int b, int c) {
        if (a > b) return numMovesStones(b, a, c);
        if (b > c) return numMovesStones(a, c, b);

        int min = 0;
        if (a + 2 == c) min = 0;
        else if (a + 1 == b || a + 2 == b || b + 1 == c || b + 2 == c) min = 1;
        else min = 2;

        return new int[]{min, c - a - 2};
    }

    /**
     * 1040. 移动石子直到连续 II
     * 在一个长度无限的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作端点石子。
     * 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。
     * 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将无法移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。
     * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
     * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 。
     */
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int min = 0;
        int max = 0;
        int len = stones.length;
        if (stones[len - 1] - stones[0] == len - 1) min = 0;
        return stones;
    }
}
