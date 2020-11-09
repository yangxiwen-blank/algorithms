package com.yb.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P1024 {
    /**
     * 1024. 视频拼接<br>
     * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。<br>
     * 这些片段可能有所重叠，也可能长度不一。<br>
     * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。<br>
     * 我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。<br>
     * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。<br>
     * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。<br>
     */
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int len = clips.length;
//        int res = -1;
        if (clips[0][0] > 0 || clips[len - 1][1] < T - 1) return -1;

//        int end = 0;
        int[] res = new int[len];
        int[] cur = new int[2];
        for (int[] clip : clips) {
//            if (end<clip[1])end
        }
        return 0;
    }

    class RandomizedCollection {
        List<Integer> list = null;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean res = list.contains(val);
            list.add(val);
            return !res;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
//            Math.random()
            return false;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return 0;
        }
    }
}
