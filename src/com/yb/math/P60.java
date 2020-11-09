package com.yb.math;

import java.util.LinkedList;
import java.util.List;

public class P60 {
    public static void main(String[] args) {
        int n = 9;
        int[] nn = new int[n];

        nn[0] = 1;
//        nn[1] = 1;
        for (int i = 1; i < n; i++) {
            nn[i] = nn[i - 1] * i;
            System.out.println("n" + i + " : " + nn[i]);
        }

        System.out.println(getPermutation(8, 10080));
    }

    public static String getPermutation(int n, int k) {
        int[] nn = new int[n + 1];
        char[] res = new char[n];
        List<Character> ns = new LinkedList<Character>();
        nn[0] = 1;
        for (int i = 1; i <= n; i++) {
            nn[i] = nn[i - 1] * i;
            ns.add((char) ('0' + i));
        }

        int c = 0;
        while (n > 0) {
            if (k % nn[n - 1] != 0) {
                int per = k / nn[n - 1];
                res[c++] = ns.remove(per);
                k = k % nn[n - 1];
            } else {
                int per = k / nn[n - 1] - 1;
                res[c++] = ns.remove(per);
                k = nn[n - 1];
            }
            --n;
        }

        return new String(res);
    }
}
