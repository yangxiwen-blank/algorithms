package com.yb.array;

import java.util.HashMap;
import java.util.Map;

public class P845 {

    public static void main(String[] args) {
//        new P845().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5, 6, 7, 8, 9, 10, 11, 10, 13, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        new P845().smallerNumbersThanCurrent(new int[]{8,1,2,2,3,324,36,6,7,58,24,4,3,6,567,678,6,87,3,5,35,5,45,46,3});
    }

    /**
     * 845. 数组中的最长山脉<br>
     * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：<br>
     * B.length >= 3<br>
     * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]<br>
     * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）<br>
     * 给出一个整数数组 A，返回最长 “山脉” 的长度。<br>
     * 如果不含有 “山脉” 则返回 0。<br>
     */
    public int longestMountain(int[] A) {
        int res = 0;
        int left = 0, right = 0;
        int len = A.length;
//        for (int i = 1; i < len - 1; ++i) {
//            //降
//            if (A[i] < A[i - 1]) {
//
//                if (left == 0) continue;
//                else right = i;
//                //升
//            } else if (A[i] > A[i - 1]) {
//                if (right > 0) {
//                    res = Math.max(res, left + right);
//                    left = 1;
//                    right = 0;
//                } else ++left;
//            } else {
//                left = 0;
//                right = 0;
//            }
//        }
        for (int i = 1; i < len - 1; ++i) {
            if (A[i] > A[i - 1] & A[i] > A[i + 1]) {
                left = i;
                while (left > 0 && A[left] > A[left - 1]) --left;
                right = i;
                while (right + 1 < len && A[right] > A[right + 1]) ++right;
                res = Math.max(res, right - left + 1);
                i = right;
            }
        }
        return res;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i] + 1));
        }

        for (int i = 0, len = nums.length; i < len; ++i) {
            int tmp = nums[i];
            nums[i] = 0;
            for (int key : map.keySet()) {
                if (key < tmp) nums[i] += map.get(key);
                if (key == tmp) break;
            }
        }
        return nums;
    }
}
