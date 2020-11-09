package com.yb.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P491 {
    /**
     * 491. 递增子序列
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 2) return res;
        List<Integer> tmp = null;
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.contains(nums[i])) {
                tmp = new ArrayList<>();
                tmp.add(nums[i]);
                findSubsequences(nums, i, tmp, res);
            }
            hash.add(nums[i]);
        }
        return res;
    }

    private void findSubsequences(int[] nums, int i, List<Integer> integers, List<List<Integer>> res) {
        Set<Integer> hash = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] >= nums[i] && !hash.contains(nums[j])) {
                List<Integer> tmp = new ArrayList<>(integers);
                tmp.add(nums[j]);
                res.add(tmp);
                hash.add(nums[j]);
                findSubsequences(nums, j, tmp, res);
            }
        }
    }
}
