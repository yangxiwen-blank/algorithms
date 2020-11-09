package com.yb.math;

import java.util.ArrayList;
import java.util.List;

public class P119 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();
        int val = 0;
        for (int i = 0; i <= rowIndex; ++i) {
            int last = 1;
            int cur = 0;
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == res.size()) val = 1;
                else {
                    cur = res.get(j);
                    val = cur + last;
                    last = cur;
                }

                if (j == res.size()) res.add(val);
                else res.set(j, val);
            }
        }
        return res;
    }

//    private List<Integer> generateRow(int num, List<Integer> tmp) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < num; ++i) {
//            if (i == 0 || i == tmp.size()) res.add(1);
//            else res.add(tmp.get(i) + tmp.get(i - 1));
//        }
//
//        return res;
//    }
}
