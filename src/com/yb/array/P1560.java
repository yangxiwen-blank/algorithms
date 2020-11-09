package com.yb.array;

import java.util.ArrayList;
import java.util.List;

public class P1560 {
    /**
     * 1560. 圆形赛道上经过次数最多的扇区
     * 给你一个整数 n 和一个整数数组 rounds 。
     * 有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。
     * 现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。
     * 其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。
     * 举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
     * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
     */
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> tail = new ArrayList<>();
        for (int i = rounds[rounds.length - 1]; i > 0; --i) {
            tail.add(0, i);
        }
        List<Integer> head = new ArrayList<>();
        for (int i = rounds[0]; i <= n; ++i) {
            head.add(i);
        }
        if (head.size() + tail.size() > n) {
            tail.retainAll(head);
        } else {
            tail.addAll(head);
        }
        return tail;
    }

}
