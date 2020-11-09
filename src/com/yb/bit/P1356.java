package com.yb.bit;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName:    P1356
 * Description:
 * Datetime:    2020/11/6   09:40
 * Author:   yangbin
 */
public class P1356 {
    /**
     * [1356]根据数字二进制下 1 的数目排序<br>
     * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。<br>
     * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。<br>
     * 请你返回排序后的数组。<br>
     *
     * 示例 1：<br>
     * 输入：arr = [0,1,2,3,4,5,6,7,8]<br>
     * 输出：[0,1,2,4,8,3,5,6,7]<br>
     * 解释：[0] 是唯一一个有 0 个 1 的数。<br>
     * [1,2,4,8] 都有 1 个 1 。<br>
     * [3,5,6] 有 2 个 1 。<br>
     * [7] 有 3 个 1 。<br>
     * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]<br>
     */
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        Integer[] b = new Integer[len];
        for (int i = 0; i < len; ++i) {
            b[i] = arr[i];
        }
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int b1 = Integer.bitCount(o1);
                int b2 = Integer.bitCount(o2);
                return b1 == b2 ? o1 - o2 : b1 - b2;
            }
        });
        for (int i = 0; i < len; ++i) {
            arr[i] = b[i];
        }
        return arr;
    }

}
