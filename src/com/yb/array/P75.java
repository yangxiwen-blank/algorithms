package com.yb.array;

public class P75 {
    /**
     * 75. 颜色分类<br>
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。<br>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     */
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        // 两次遍历
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] == 0) r += 1;
            else if (nums[i] == 1) w += 1;
            else b += 1;
        }

        for (int i = 0, len = nums.length; i < len; ++i) {
            if (i < r) nums[i] = 0;
            else if (i < r + w) nums[i] = 1;
            else nums[i] = 2;
        }

        //一次遍历
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] == 0) {
                nums[r] = 0;
                nums[r + w] = 1;
                nums[i] = 2;
                r += 1;
            } else if (nums[i] == 1) {
                nums[r + w] = 1;
                nums[i] = 2;
                w += 1;
            }
        }
    }
}
