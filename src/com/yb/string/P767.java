package com.yb.string;

import java.util.Arrays;

/**
 * ClassName:    P767
 * Description:
 * Datetime:    2020/11/6   14:19
 * Author:   yangbin
 */
public class P767 {
    public static void main(String[] args) {
        System.out.println(new P767().reorganizeString("ogccckcwmbmxtsbmozli"));
    }

    /**
     * 767. 重构字符串<br>
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。<br>
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     */
    public String reorganizeString(String S) {
        int[][] cs = new int[26][2];
        int sum = S.length();
        int max = (sum + 1) / 2;
        for (char c : S.toCharArray()) {
            cs[c - 'a'][1] += 1;
            if (max < cs[c - 'a'][1]) return "";
        }
        for (int i = 0; i < 26; ++i) {
            cs[i][0] = i;
        }
        char[] chars = new char[sum];
        Arrays.sort(cs, (a, b) -> b[1] - a[1]);
        int pos = 0;
        for (int[] c : cs) {
            if (c[1] == 0) break;
            for (; pos < sum; ) {
                chars[pos] = (char) ('a' + c[0]);
                pos += 2;
                if (pos >= sum) pos = 1;
                if (--c[1] == 0) break;
            }
        }
        return new String(chars);

        /*// 堆排
        int[][] cs = new int[26][2];
        int sum = S.length();
        int max = (sum + 1) / 2;
        for (char c : S.toCharArray()) {
            cs[c - 'a'][1] += 1;
            if (max < cs[c - 'a'][1]) return "";
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; ++i) {
            if (cs[i][1] == 0) continue;
            cs[i][0] = i;
            queue.offer(cs[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            sb.append((char) ('a' + a[0]));
            if (queue.isEmpty()) break;
            int[] b = queue.poll();
            sb.append((char) ('a' + b[0]));
            if (--a[1] > 0) queue.offer(a);
            if (--b[1] > 0) queue.offer(b);
        }
        return sb.toString();*/
    }
}
