package com.yb.dp;

/**
 * ClassName:    P357
 * Description:
 * Datetime:    2020/11/6   13:48
 * Author:   yangbin
 */
public class P357 {
    public static void main(String[] args) {
        new P357().countNumbersWithUniqueDigits(10);
    }
    /**
     * 357. 计算各个位数不同的数字个数<br>
     * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n >= 10) n = 10;
        int[] dp = new int[n + 1];
        dp[0] = 9;
        int sum = 10;
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] * (10 - i);
            sum += dp[i];
            System.out.println("n: "+(i+1)+" dp: "+dp[i] +" sum: "+sum);
        }
        return sum;
    }
}
