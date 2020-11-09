package com.yb.math;

public class P1523 {
    /**
     * 1523. 在区间范围内统计奇数数目<br>
     * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
     */
    public int countOdds(int low, int high) {
        return (high - low) / 2 + (low % 2 | high % 2);
    }
}
