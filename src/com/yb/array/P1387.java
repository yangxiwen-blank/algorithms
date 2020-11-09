package com.yb.array;

import java.util.*;

/**
 * ClassName:    P1387
 * Description:
 * Datetime:    2020/11/6   10:31
 * Author:   yangbin
 */
public class P1387 {
    int[] weights = new int[1000];
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; ++i) {
            System.out.println("num : " + i + "    weight: " + getWeight(i));
        }
    }

    private static int getWeight(int i) {
        int weight = 0;
        while (i != 1) {
            if (i % 2 == 0) i /= 2;
            else i = i * 3 + 1;
            weight += 1;
        }
        return weight;
    }

    /**
     * 1387. 将整数按权重排序<br>
     * 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：<br>
     * 如果 x 是偶数，那么 x = x / 2<br>
     * 如果 x 是奇数，那么 x = 3 * x + 1<br>
     * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。<br>
     * 给你三个整数 lo， hi 和 k 。<br>
     * 你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。<br>
     * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。<br>
     * 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
     */
    public int getKth(int lo, int hi, int k) {
        List<int[]> nums = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        // List<Integer> weights = new ArrayList<>();
        for (int i = lo; i <= hi; ++i) {
            queue.offer(new int[]{i, getWeight(i)});
            if (queue.size() > k) queue.poll();
            // nums.add(new int[]{i, getWeight(i)});
        }
        // Collections.sort(nums, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        // return nums.get(k - 1)[0];
        return queue.poll()[0];
    }

    private int getWeight3(int i) {
        if (map.containsKey(i)) return map.get(i);
        if (i == 1) {
            map.put(1, 1);
            return 1;
        } else if (i % 2 == 0) {
            int n = getWeight2(i /= 2) + 1;
            map.put(i, n);
            return n;
        } else {
            int n = getWeight2(i * 3 + 1) + 1;
            map.put(i, n);
            return n;
        }
    }

    private int getWeight2(int i) {
        if (i == 1) return 1;
        else if (i % 2 == 0) return getWeight2(i /= 2) + 1;
        else return getWeight2(i * 3 + 1) + 1;
    }
}
