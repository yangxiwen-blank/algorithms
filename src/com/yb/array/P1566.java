package com.yb.array;

/**
 * 1566. 重复至少 K 次且长度为 M 的模式<br>
 * 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。<br>
 * 模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。<br>
 * 如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
 */
public class P1566 {
    public static boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length;
        if (len < m * k) return false;

        boolean valid = true;
        int count = 0;
        int res = 0;
        for (int i = m; i < len; ++i) {
            if (valid && arr[i] == arr[i - m]) {
                ++count;
            } else if (arr[i] == arr[i - m]) {
                res = Math.max(res, count);
                count = 1;
                valid = true;
            } else
                valid = false;
        }
        res = Math.max(res, count);
        return res / m >= k - 1;
    }
}
