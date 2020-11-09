package com.yb.string;

public class P1578 {
    /**
     * 1578. 避免重复字母的最小删除成本
     * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
     * 返回使字符串任意相邻两个字母不相同的最小删除成本。
     * 请注意，删除一个字符后，删除其他字符的成本不会改变。
     */
    public int minCost(String s, int[] cost) {
        char[] cs = s.toCharArray();

        int res = 0;
        for (int i = 1, len = cs.length; i < len; ++i) {
            if (cs[i] == cs[i - 1]) {
                res += Math.min(cost[i], cost[i - 1]);
                cost[i] = Math.max(cost[i], cost[i - 1]);
            }
        }
        return res;
    }
}
