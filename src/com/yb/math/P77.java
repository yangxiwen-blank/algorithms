package com.yb.math;

import java.util.ArrayList;
import java.util.List;

public class P77 {
    List<List<Integer>> res = null;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        combine(n, k, 0, new ArrayList<>());
        return res;
    }

    private void combine(int n, int k, int i, List<Integer> es) {
//        if (n + i + es.size() < k) return;
        if (es.size() == k) {
            res.add(new ArrayList<>(es));
            return;
        }
//        int max = Math.min(n, n - k + es.size() + 1);
        for (int j = i + 1; j <= n - k + es.size() + 1; ++j) {
//            List<Integer> tmp = new ArrayList<>(es);
            es.add(j);
            combine(n, k, j, es);
            es.remove(es.size() - 1);
        }
    }
}
