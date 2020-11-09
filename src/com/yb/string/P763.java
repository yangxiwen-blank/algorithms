package com.yb.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P763 {
    public static void main(String[] args) {
        new P763().partitionLabels("ababccdefegdehijhklij");
    }

    /**
     * 763. 划分字母区间
     * 字符串 S 由小写字母组成。
     * 我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
     * 返回一个表示每个字符串片段的长度的列表。
     */
    public List<Integer> partitionLabels(String S) {
        int[][] pos = new int[26][2];
        List<Integer> res = new ArrayList<>();
        int len = S.length();
        for (int i = 0; i < len; ++i) {
            char c = S.charAt(i);
            if (pos[c - 'a'][0] == 0) pos[c - 'a'][0] = i + 1;
            pos[c - 'a'][1] = i + 1;
        }
        Arrays.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int max = 0;
        int s = 0;
        for (int i = 0; i < 26; ++i) {
            if (pos[i][0] == 0) continue;
            if (max == 0) {
                s = pos[i][0];
                max = pos[i][1];
            } else if (max > pos[i][1]) continue;
            else if (max < pos[i][0]) {
                res.add(max - s + 1);
                s = pos[i][0];
                max = pos[i][1];
            } else max = pos[i][1];
        }
        res.add(max - s + 1);
        return res;
    }
}
