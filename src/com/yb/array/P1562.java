package com.yb.array;

public class P1562 {

    /**
     * 1562. 查找大小为 M 的最新分组<br>
     * 给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。<br>
     * 在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 。<br>
     * 给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。<br>
     * 返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。<br>
     * <p>
     * <p>
     * n == arr.length<br>
     * 1 <= n <= 10^5<br>
     * 1 <= arr[i] <= n<br>
     * arr 中的所有整数 互不相同<br>
     * 1 <= m <= arr.length<br>
     */
    public int findLatestStep(int[] arr, int m) {
        int len = arr.length;
        if (len == m) return m;
        int[] a = new int[len];

        int tmp = 0;
        for (int i = len - 1; i >= m; --i) {
            tmp = arr[i] - 1;
            a[tmp] = 1;
            if (a[tmp] + m < len) {
                for (int j = 0; j <= m; ++j) {
                    if (a[tmp + j] == 1) break;
                }
            }

            if (a[tmp] - m >= 0) {

            }
        }
        int res = -1;
        return res;
    }
}
