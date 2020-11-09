package com.yb.bfs;

import java.util.*;

public class P752 {

    /**
     * 752. 打开转盘锁
     * 你有一个带有四个圆形拨轮的转盘锁。
     * 每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
     * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。
     * 每次旋转都只能旋转一个拨轮的一位数字。
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     */
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains(target) || set.contains("0000")) return -1;
        boolean[][] lock = new boolean[4][10];

        for (String deadend : deadends) {
            lock[0][deadend.charAt(0) - '0'] = true;
            lock[1][deadend.charAt(1) - '0'] = true;
            lock[2][deadend.charAt(2) - '0'] = true;
            lock[3][deadend.charAt(3) - '0'] = true;
        }

//        boolean locked = false;
//        int res = 0;
//        for (int i = 0; i < 4; ++i) {
//            int c = target.charAt(i) - '0';
//            res += Math.min(c, 10 - c);
//            boolean lockl = true, lockr = true;
//            for (int j = c; j <= 10; ++j) {
//                if (lock[i][j % 10]) lockr = false;
//            }
////            for
//            for (int j = c; j >= 0; --j) {
//                if (lock[i][j % 10]) lockl = false;
//            }
//            locked = lockl || lockr;
//        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        String tmp = "";
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; ++i) {

                String cur = queue.poll();
                char[] cs = cur.toCharArray();
                if (set.contains(cur)) continue;
                for (int j = 0; j < 4; ++j) {
                    int c = cs[j] - '0';
                    int l = (10 + c - 1) % 10;
                    int r = (10 + c + 1) % 10;
                    if (!lock[j][l]) {
                        cs[j] = (char) ('0' + l);
                        queue.offer(new String(cs));
//                        lo
                    }
                    tmp = new String(cs);
//                    if (set.)
                }
            }
        }

        return -1;
    }
}
