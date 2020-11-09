package com.yb.array;

import java.util.Arrays;

public class P1561 {

    /**
     * 1561. 你可以获得的最大硬币数目<br>
     * 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：<br>
     * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。<br>
     * Alice 将会取走硬币数量最多的那一堆。<br>
     * 你将会取走硬币数量第二多的那一堆。<br>
     * Bob 将会取走最后一堆。<br>
     * 重复这个过程，直到没有更多硬币。<br>
     * 给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。<br>
     * 返回你可以获得的最大硬币数目。
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int len = piles.length;
        int n = len / 3;
        int res = 0;
        for (int i = len - 1; i >= n; i -= 2) {
            res += piles[i - 1];
        }
        return res;
    }
}
