package com.yb.array;

import java.util.Arrays;

public class Profit {
    /**
     * 121. 买卖股票的最佳时机<br>
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。<br>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。<br>
     * 注意：你不能在买入股票前卖出股票。<br>
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int val = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = Math.min(low, prices[i]);
            } else {
                val = Math.max(val, prices[i] - low);
            }
        }

        return val < 0 ? 0 : val;
    }

    /**
     * 122. 买卖股票的最佳时机II<br>
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。<br>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。<br>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。<br>
     */
    public int maxProfitII(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int total = 0;
        int val = 0;
        int low = prices[0];
        int high = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = Math.min(low, prices[i]);
            } else {
                high = prices[i];
                val = Math.max(val, prices[i] - low);
                total += val;
                val = 0;
            }
            if (prices[i] < high) {
                low = prices[i];
            }
        }

        // 简化版
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                total += prices[i] - prices[i - 1];
        }
        return total;
    }

    /**
     * 123. 买卖股票的最佳时机III<br>
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。<br>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。<br>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。<br>
     */
    public int maxProfitIII(int[] prices) {
        /**
         * <pre>[3,1,5,0,0,3,1,4] 执行错误,未考虑可执行次数>2且可合并
         * int[] val = new int[prices.length / 2];
         * int low = prices[0];
         * int count = 0;
         * for (int i = 1; i < prices.length; i++) {
         * 	if (prices[i] < low) {
         * 		low = Math.min(low, prices[i]);
         *    } else {
         * 		val[count] = Math.max(val[count], prices[i] - low);
         *    }
         * 	if (prices[i] < prices[i - 1] && val[count] != 0) {
         * 		count++;
         * 		low = prices[i];
         *    }
         * }
         * if (count == 0) {
         * 	return val[0];
         * }
         * int[] val2 = new int[count + 1];
         * for (int i = 0; i <= count; i++) {
         * 	val2[i] = val[i];
         * }
         * Arrays.sort(val2);
         * return val2[count] + val2[count - 1];
         * </pre>
         */
        return maxProfit(2, prices);
    }

    /**
     * 188. 买卖股票的最佳时机 IV
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        //记录买入价格
        int[] buy = new int[prices.length / 2];
        //记录售出价格
        int[] sell = new int[prices.length / 2];
        //假设第一天就买入
        buy[0] = prices[0];
        //计次完整交易（买入卖出）
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy[count]) {
                // 一次卖出后，计次+1，并假设次日买入
                if (sell[count] != 0) ++count;
                //价格走势降低，在最低点买入
                buy[count] = Math.min(buy[count], prices[i]);
            } else {
                //价格走势上扬，在最高点卖出
                sell[count] = Math.max(sell[count], prices[i]);
            }
            if (prices[i] < prices[i - 1] && sell[count] != 0) {
                count++;
                buy[count] = prices[i];
            }
        }
        //如果最后没有卖出，不买入，最大交易count次
        if (sell[count] == 0) {
            buy[count] = 0;
        }
        int[] val = new int[count - 1];
        int res = 0;
        for (int i = 0; i < count; i++) {
            res += sell[i] - buy[i];
            if (i > 0)
                val[i - 1] = buy[i] - sell[i - 1];
        }

        Arrays.sort(val);
        int diff = count - k;
        for (int i = 0; i < diff; i++) {
            res += val[i];
        }
        return res;
    }

    /**
     * 309. 最佳买卖股票时机含冷冻期
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     */
    public int maxProfitWithCold(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}