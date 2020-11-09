package com.yb.math;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:    P447
 * Description:
 * Datetime:    2020/11/6   16:55
 * Author:   yangbin
 */
public class P447 {
    public static void main(String[] args) {
        // for (int i = 2; i < 7; ++i) {
        //
        //     System.out.println(new P447().A(i));
        // }

            System.out.println(new P447().numberOfBoomerangs(new int[][]{{0,0},{3,4},{-3,4},{4,-3},{-4,3},{3,-4},{-3,-4}}));
    }

    /**
     * 447. 回旋镖的数量<br>
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，<br>
     * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。<br>
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     */
    public int numberOfBoomerangs(int[][] points) {
        Map<String, Integer> map = new HashMap<>();
        int len = points.length;
        int res = 0;
        for (int i = 0; i < len; ++i) {
            Map<Integer, Integer> diss = new HashMap<>();
            for (int j = 0; j < len; ++j) {
                int dis = 0;
                if (j < i) dis = map.get(j + "-" + i);
                else if (i == j) continue;
                else {
                    dis = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    map.put(i + "-" + j, dis);
                }
                int c = diss.getOrDefault(dis, 0);
                diss.put(dis, c + 1);
            }
            for (int dis : diss.keySet()) {
                int c = diss.get(dis);
                if (c == 1) continue;
                res += A(c);
            }
        }
        return res;
    }

    private int A(int c) {
        if (c == 2) return 2;
        return c * A(c - 1);
    }
}
