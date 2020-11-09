package com.yb.dfs;

import java.util.*;

public class Combination {
    List<List<Integer>> res39 = new ArrayList<List<Integer>>();
    List<List<Integer>> res40 = new ArrayList<List<Integer>>();
    List<List<Integer>> res216 = new ArrayList<List<Integer>>();
    int res377 = 0;
    Map<Integer, Long> map = new HashMap<>();

    /**
     * 39. 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<Integer>(), 0);
        return res39;
    }

    private void combinationSum(int[] candidates, int target, List<Integer> tmp, int start) {
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] < target) {
                List<Integer> il = new ArrayList<>(tmp);
                il.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], il, i);
            } else if (candidates[i] == target) {
                List<Integer> il = new ArrayList<>(tmp);
                il.add(candidates[i]);
                res39.add(il);
            } else {
                break;
            }
        }
    }

    /**
     * 34. 组合总和
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, new ArrayList<Integer>(), 0);
        return res40;
    }

    private void combinationSum2(int[] candidates, int target, List<Integer> tmp, int start) {
        for (int i = start; i < candidates.length; i++) {
            // 排除重复
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            List<Integer> il = new ArrayList<>(tmp);
            if (candidates[i] < target) {
                il = new ArrayList<>(tmp);
                il.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], il, i + 1);//+1：只使用一次
            } else if (candidates[i] == target) {
                il.add(candidates[i]);
                res40.add(il);
            } else {
                break;
            }
        }

        // 优化结构（好看
//        if (target == 0) {
//            res40.add(tmp);
//            return;
//        }
//        for (int i = start; i < candidates.length; i++) {
//            if (candidates[i] > target) break;
//            // 排除重复
//            if (i > start && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
//            List<Integer> il = new ArrayList<>(tmp);
//            il.add(candidates[i]);
//            combinationSum2(candidates, target - candidates[i], il, i + 1);//+1：只使用一次
//        }
    }

    /**
     * 216. 组合总和 III
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     * 说明：
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n != 0)
            combinationSum3(k, n, new ArrayList<Integer>(), 1);
        return res216;
    }

    private void combinationSum3(int k, int n, List<Integer> tmp, int start) {
        if (n == 0 && tmp.size() == k) {
            res216.add(tmp);
            return;
        }
        if (n <= 0 || tmp.size() >= k) return;
        for (int i = start; i <= 9; ++i) {
            if (i > n) break;
            List<Integer> il = new ArrayList<>(tmp);
            il.add(i);
            combinationSum3(k, n - i, il, i + 1);
        }
    }

    /**
     * 377. 组合总和 Ⅳ
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     */
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        // 暴力强算，超时
        combinationSum4(nums, target, 0);

        // 动态规划
        int[] dp = new int[target + 1];
        //dp[0]表示target=0 ，结果+1
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (num <= i)
                    dp[i] += dp[i - num];
                //dp[7]=dp[1]+dp[2]+dp[4];
            }
//            dp[i] = dp[i - 1] + combinationSum4(nums, i, dp);
        }

        return dp[target];
    }

    private void combinationSum4(int[] nums, int target, int i) {
        if (target == 0) ++res377;
        if (target < 0) return;
        for (int j = 0; j < nums.length; ++j) {
            target -= nums[j];

//            if (map.containsKey(target)) res377 += map.get(target);
//            else
            combinationSum4(nums, target, i + 1);
        }

    }
}
