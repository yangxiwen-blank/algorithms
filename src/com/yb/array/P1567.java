package com.yb.array;

/**
 * 1567. 乘积为正数的最长子数组长度<br>
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。<br>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。<br>
 * 请你返回乘积为正数的最长子数组长度。<br>
 */
public class P1567 {
    public int getMaxLen(int[] nums) {
        return Math.max(getMax(nums), getRMax(nums));
    }

    private int getMax(int[] nums) {
        int res = 0;
        int count = 0;
        int tmp = 0;
        for (int i : nums) {
            if (tmp > 0)
                if (i > 0) ++tmp;
                else if (i == 0) {
                    res = Math.max(res, Math.max(count, tmp - 1));
                    tmp = 0;
                    count = 0;
                } else {
                    count += tmp + 1;
                    tmp = 0;
                }
            else {
                if (i > 0) ++count;
                else if (i == 0) {
                    res = Math.max(res, count);
                    count = 0;
                } else ++tmp;
            }
        }

        return Math.max(res, Math.max(count, tmp - 1));
    }

    private int getRMax(int[] nums) {
        int res = 0;
        int count = 0;
        int tmp = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (tmp > 0)
                if (nums[i] > 0) ++tmp;
                else if (nums[i] == 0) {
                    res = Math.max(res, Math.max(count, tmp - 1));
                    tmp = 0;
                    count = 0;
                } else {
                    count += tmp + 1;
                    tmp = 0;
                }
            else {
                if (nums[i] > 0) ++count;
                else if (nums[i] == 0) {
                    res = Math.max(res, count);
                    count = 0;
                } else ++tmp;
            }
        }

        return Math.max(res, Math.max(count, tmp - 1));
    }
}
