package com.yb.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P334 {
    public static void main(String[] args) {
        System.out.println(new P334().increasingTriplet(new int[]{1, 2, 3, 1, 2, 1}));
        System.out.println("John".compareTo("Jon"));
    }

    /**
     * 334. 递增的三元子序列<br>
     * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。<br>
     * 数学表达式如下:<br>
     * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，<br>
     * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。<br>
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。<br>
     */
    public boolean increasingTriplet(int[] nums) {
//        for (int i = 2, len = nums.length; i < len; ++i) {
//            if (nums[i] > nums[i - 1] && nums[i - 1] > nums[i - 2]) return true;
//        }
//        return false;
        int min = nums[0];
        int max = min - 1;
        List<Stack<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, len = nums.length; i < len; ++i) {
//            if (max > min && nums[i] > max) return true;
//            if (nums[i] > min) max = min;
//
//            boolean add = false;
//            for (int j = 0, len2 = list.size(); j < len2; ++j) {
//                if (list.get(j).peek() < nums[i]) {
//                    if (list.get(j).size() == 2) return true;
//                    list.get(j).push(nums[i]);
//                    add = true;
//                    break;
//                }
//            }
//            if (add) continue;
//            Stack<Integer> stack = new Stack<>();
//            stack.push(nums[i]);
//            list.add(stack);
            while (stack.size() > 0 && stack.peek() >= nums[i]) stack.pop();
            stack.push(nums[i]);
            if (stack.size() == 3) return true;
        }
//        return false;

        int len = nums.length;
        if (len < 3) return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else if (num > mid) {
                return true;
            }
        }
        return false;

    }
}
