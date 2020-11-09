package com.yb.matrix.diagonal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P1424 {
    /**
     * 1424. 对角线遍历 II
     * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        /** 转化二维数组 （内存超限）
         * <pre>
         int r = nums.size();
         int c = 0;
         int totle = 0;
         for (int i = 0; i < r; i++) {
         totle += nums.get(i).size();
         c = Math.max(c, nums.get(i).size());
         }

         String[][] grid = new String[r][c];

         int count = 0;
         for (int i = 0; i < r; i++) {
         Arrays.fill(grid[i], ".");
         List<Integer> tmp = nums.get(i);
         count = 0;
         for (int j : tmp) {
         grid[i][count++] = "" + j;
         }
         }

         int num = 0;
         int[] res = new int[totle];
         for (int i = 0; i < r; ++i) {
         int m = i;
         int n = 0;
         for (; m >= 0 && n < c; --m, ++n) {
         if (grid[m][n].equals(".")) continue;
         res[num++] = Integer.parseInt(grid[m][n]);
         }
         }
         for (int i = 1; i < c; ++i) {
         int m = r-1;
         int n = i;
         for (; m >= 0 && n < c; --m, ++n) {
         if (grid[m][n].equals(".")) continue;
         res[num++] = Integer.parseInt(grid[m][n]);
         }
         }

         return res;</pre>
         */

        /** 转化二维数组 （超时）
         * <pre>
         int r = nums.size();
         int c = 0;
         int totle = 0;
         for (int i = 0; i < r; i++) {
         totle += nums.get(i).size();
         c = Math.max(c, nums.get(i).size() - r + i);
         }

         int[] res = new int[totle];
         int num = 0;

         for (int i = 0; i < r; ++i) {
         int m = i;
         int n = 0;
         for (; m >= 0 && n < c; --m, ++n) {
         try {
         int tmp = nums.get(m).get(n);
         res[num++] = tmp;
         } catch (Exception e) {
         }
         //                if (grid[m][n].equals(".")) continue;
         //                res[num++] = Integer.parseInt(grid[m][n]);
         }
         }
         for (int i = 1; i < c; ++i) {
         int m = r - 1;
         int n = i;
         for (; m >= 0 && n < c; --m, ++n) {
         try {
         int tmp = nums.get(m).get(n);
         res[num++] = tmp;
         } catch (Exception e) {
         }
         }
         }
         return res;

         //超时
         int r = nums.size();
         int[] lens = new int[r];
         int c = 0;
         int totle = 0;
         for (int i = 0; i < r; i++) {
         lens[i] = nums.get(i).size();
         totle += lens[i];
         c = Math.max(c, lens[i] - r + i);
         }

         int[] res = new int[totle];
         int num = 0;

         for (int i = 0; i < r; ++i) {
         int m = i;
         int n = 0;
         for (; m >= 0 && n < c; --m, ++n) {
         if (lens[m] > n) res[num++] = nums.get(m).get(n);
         }
         }

         for (int i = 1; i < c; ++i) {
         int m = r - 1;
         int n = i;
         for (; m >= 0 && n < c; --m, ++n) {
         if (lens[m] > n) res[num++] = nums.get(m).get(n);
         }
         }

         return res;</pre>
         */

        int r = nums.size();
        int totle = 0;
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < r; i++) {
            int len = nums.get(i).size();
            totle += len;
            for (int j = 0; j < len; j++) {
                List<Integer> tmp = map.getOrDefault(i + j, new ArrayList<>());
                tmp.add(nums.get(i).get(j));
                map.put(i + j, tmp);
            }
        }

        int[] res = new int[totle];
        int num = 0;

        for (List<Integer> list : map.values()) {
            for (int i = list.size() - 1; i >= 0; --i) {
                res[num++] = list.get(i);
            }
        }
        return res;
    }
}
