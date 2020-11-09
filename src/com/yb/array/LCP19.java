package com.yb.array;

public class LCP19 {
    public static void main(String[] args) {
        new LCP19().minimumOperations("yyyyyyyyyyyyrryryryryryry");
    }

    /**
     * LCP 19. 秋叶收藏集<br>
     * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves，<br>
     * 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。<br>
     * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。<br>
     * 每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。<br>
     */
    public int minimumOperations(String leaves) {
        char[] cs = leaves.toCharArray();
        int res = 0;
        int len = cs.length;
        int[] nums = new int[len];
        int c = 0;
        if (cs[0] != 'r') {
            cs[0] = 'r';
            nums[c] = 1;
            res += 1;
        }
        if (cs[len - 1] != 'r') {
            cs[0] = 'r';
//            nums[]
            res += 1;
        }
        for (int i = 1; i < len; ++i) {
            if (cs[i] != cs[i - 1]) c += 1;
            nums[c] += 1;
        }
        if (c == 2) return res;

        int d = 0, s = 0;
        for (int i = 1; i < c - 1; ++i) {
            if (i % 2 == 0) d += nums[i];
            else s += nums[i];
        }
        return res + Math.min(d, s);

//        Character
//动态规划
//        int n = leaves.length();
//        int[][] f = new int[n][3];
//        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
//        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
//        for (int i = 1; i < n; ++i) {
//            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
//            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
//            f[i][0] = f[i - 1][0] + isYellow;
//            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
//            if (i >= 2) {
//                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
//            }
//        }
//        return f[n - 1][2];

    }
}
