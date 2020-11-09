package com.yb.array;

import java.util.Arrays;

public class P5508 {
    /**
     * 给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
     * <p>
     * 类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
     * 类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
     * <p>
     * 1 <= nums1.length, nums2.length <= 1000
     * 1 <= nums1[i], nums2[i] <= 10^5
     */
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return numTriplets2(nums1, nums2) + numTriplets2(nums2, nums1);
    }

    public int numTriplets2(int[] nums1, int[] nums2) {

        int len = nums2.length;
        int res = 0;
        int zh1 = 0;
        int numof1 = 0;
        int sign = 0;
        for (int i = 0; i < len; i++) {
            zh1 += i;
            if (nums2[i] != 1) {
                sign = i;
                numof1 = i;
                break;
            }
        }
        for (int i : nums1) {
            if (i > nums2[len - 1]) break;
            if (i < nums2[0]) continue;
            if (i == 1) {
                res += zh1;
                continue;
            }
//            if (i==nums2[sign])
            while (i > nums2[sign]) {
                ++sign;
            }
            sign = findSign(i, nums2, sign);
        }

        return res;
    }

    private int findSign(int i, int[] nums2, int s) {
        while (s < nums2.length && s >= 0) {
            if (i <= nums2[s] && i >= nums2[s - 1])
                return s;
            if (i > nums2[s])
                ++s;
            if (i < nums2[s - 1])
                --s;
        }
        return s;
    }
}
