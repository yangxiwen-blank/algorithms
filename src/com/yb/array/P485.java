package com.yb.array;

public class P485 {

    /**
     * 485. 最大连续1的个数
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0, fast = 0;
        int res = 0;
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] != 1) {
//                res = Math.max(res, fast - slow);
//                slow = i;
//            }
//            ++fast;
//        }
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                res = Math.max(res, fast - slow);
                slow = fast;
            }
            fast++;
        }
        return Math.max(res, fast - slow);
    }
}
