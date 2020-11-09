package com.yb.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347 {

    /**
     * 347. 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        // 哈希计数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
//            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 键值对换
//        Map<Integer, List<Integer>> countMap = new HashMap<>();
//        map.entrySet().forEach((entry) -> {
//            List<Integer> tmp = new ArrayList<>();
//            tmp = countMap.getOrDefault(entry.getValue(), tmp);
//            tmp.add(entry.getKey());
//            countMap.put(entry.getValue(), tmp);
//        });
//
//        // 出现次数列表
//        List<Integer> keys = new ArrayList<>();
//        keys.addAll(countMap.keySet());
//        keys.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        int c = 0;
//        for (int i : keys) {
//            List<Integer> tmp = countMap.get(i);
//            for (int j : tmp) {
//                res[c++] = j;
//                if (c == k) return res;
//            }
//        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        map.entrySet().forEach((entry) -> {
            if (queue.size() == k) {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            } else
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
        });

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
