package com.yb.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class P279 {

    /**
     * 279. 完全平方数
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     */
    public int numSquares(int n) {
//        int m = (int) Math.pow(n, 0.5);
//
//        for (int i = 1; i <= m; ++i) {
//            if (n % (m * m) == 0) return n / (m * m);
//        }
        int res = 0;
//        while (n>0){
//            n -= Math.pow((int) Math.pow(n, 0.5), 2);
//            res += 1;
//        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; ++i) {
                n = queue.poll();
                if (n == 0) return res;
                if (n < 0) continue;

                int m = (int) Math.pow(n, 0.5);

                for (int j = m; j > 1; --j) {
                    queue.offer((int) (n - Math.pow(j, 2)));
                }
//                if (m > 1)
//                    queue.offer((int) (n - Math.pow(m - 1, 2)));
            }

//            System.out.print(n + " ");
//            n -= Math.pow((int) Math.pow(n, 0.5), 2);
            res += 1;
        }
        return 0;
    }
}
