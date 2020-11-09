package com.yb.dp;

/**
 * 486. 预测赢家<br>
 * 给定一个表示分数的非负整数数组。 <br>
 * 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。<br>
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。<br>
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。<br>
 */
public class P486 {
    //TODO 状态转移方程未理解
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int[] dp = new int[len];
        int[] dp2 = new int[len];

        int i = 0;
        boolean pleft = true;
        while (left <= right) {
            if ((right - left > 2 && nums[left] + Math.max(nums[left + 2], nums[right - 1]) >= Math.max(nums[left + 1], nums[right]))
                    || (right - left > 1 && nums[left] + Math.min(nums[left + 1], nums[right]) >= Math.max(nums[left + 1], nums[right]))
                    || nums[left] >= nums[right])
                pleft = true;
            else pleft = false;

            if (pleft) {
                dp[i] = i > 1 ? dp[i - 2] : 0 + nums[left];
                ++left;
            } else {
                dp[i] = i > 1 ? dp[i - 2] : 0 + nums[right];
                --right;
            }
            i++;
        }

        // 奇数长度，最后一个是玩家1拿
        if (len % 2 == 1) return dp[len - 1] >= dp[len - 2];
        else return dp[len - 1] <= dp[len - 2];
    }
}
