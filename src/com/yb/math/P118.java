package com.yb.math;

import java.util.ArrayList;
import java.util.List;

public class P118 {

    /**
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            tmp = generateRow(i + 1, tmp);
            res.add(tmp);
        }
        return res;
    }

    private List<Integer> generateRow(int num, List<Integer> tmp) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            if (i == 0 || i == tmp.size()) res.add(1);
            else res.add(tmp.get(i) + tmp.get(i - 1));
        }

        return res;
    }
}
