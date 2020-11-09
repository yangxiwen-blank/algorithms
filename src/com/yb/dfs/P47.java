package com.yb.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P47 {

    List<List<Integer>> res = null;

    /**
     * 47. 全排列 II<br>
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        generatePermutation(nums, 0);
        return res;
    }

    private void generatePermutation(int[] nums, int start) {
        if (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
//                if (nums[start] == nums[i]) continue;
                int[] temp = Arrays.copyOf(nums, nums.length);

                // 交换第start个元素与第i个元素
                int charStart = temp[start];
                temp[start] = temp[i];
                temp[i] = charStart;

                if (start == nums.length - 1) {
                    List<Integer> item = new ArrayList<>();
                    for (int j = 0; j <= start; ++j) {
                        item.add(temp[j]);
                    }
                    res.add(item);
                }
//                while (n)
                generatePermutation(temp, start + 1);
            }
        }
    }

    private void dfs(int[] nums, int i, List<Integer> integers) {
        if (i == nums.length - 1) res.add(integers);
    }
}
