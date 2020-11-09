package com.yb.array;

public class P283 {

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
                // 一次遍历
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow++] = tmp;
            }
            ++fast;
        }

//        while (slow < nums.length) {
//            nums[slow++] = 0;
//        }
    }
}
