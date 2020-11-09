package com.yb.array;

public class P189 {
    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    public void rotate(int[] nums, int k) {
        // 原版非原地
        int len = nums.length;
        k = k % len;
        if (k == 0) return;
        int[] tmp = new int[k];
        int c = 0;
        for (int i = len - k; i < len; ++i) {
            tmp[c++] = nums[i];
        }

        for (int i = len - 1; i >= k; --i) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; ++i) {
            nums[i] = tmp[i];
        }

        // 暴力原地
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }

        // 环状替代 原地
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int tmp1 = nums[next];
                nums[next] = prev;
                prev = tmp1;
                current = next;
                count++;
            } while (start != current);
        }

        // 分次反转 原地
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
