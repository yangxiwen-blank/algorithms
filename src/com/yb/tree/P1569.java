package com.yb.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1569. 将子数组重新排序得到同一个二叉查找树的方案数
 * 给你一个数组 nums 表示 1 到 n 的一个排列。我们按照元素在 nums 中的顺序依次插入一个初始为空的二叉查找树（BST）。
 * 请你统计将 nums 重新排序后，统计满足如下条件的方案数：重排后得到的二叉查找树与 nums 原本数字顺序得到的二叉查找树相同。
 * 比方说，给你 nums = [2,1,3]，我们得到一棵 2 为根，1 为左孩子，3 为右孩子的树。
 * 数组 [2,3,1] 也能得到相同的 BST，但 [3,2,1] 会得到一棵不同的 BST 。
 * 请你返回重排 nums 后，与原数组 nums 得到相同二叉查找树的方案数。
 * 由于答案可能会很大，请将结果对 10^9 + 7 取余数。
 *
 * TODO 完全不会
 * <u>该方法为竞赛难度，代码不做解释。看懂代码需要如下的预备知识点：
 *
 * 乘法逆元、费马小定理与组合数计算
 * 使用路径压缩和按秩合并优化的并查集
 * 简要思路可以期待一下这题的官方题解。</u>
 */
public class P1569 {
    int N = 1010, mod = (int) 1e9 + 7;
    int[][] C = new int[N][N];

    public int numOfWays(int[] nums) {
        int n = nums.length;
        init(n);
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) list.add(nums[i]);
        return f(list) - 1;
    }

    public int f(List<Integer> list) {
        if (list.isEmpty()) return 1;
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        int n = list.size();
        int r = list.get(0);
        for (int i = 1; i < n; i++) {
            if (list.get(i) <= r) left.add(list.get(i));
            else right.add(list.get(i));
        }
        return (int) ((long) C[n - 1][left.size()] * f(left) % mod * f(right) % mod);
    }

    //求组合数， 因为题目数据范围比较小
    public void init(int n) {
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= a; b++) {
                if (b == 0) C[a][b] = 1;
                else {
                    C[a][b] = (C[a - 1][b] + C[a - 1][b - 1]) % mod;
                }
            }
        }
    }
}
