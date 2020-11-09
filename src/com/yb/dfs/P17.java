package com.yb.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17 {
    /**
     * 17. 电话号码的字母组合<br>
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。<br>
     * 给出数字到字母的映射如下（与电话按键(九宫键盘)相同）。注意 1 不对应任何字母。<br>
     */
    public List<String> letterCombinations(String digits) {
        Map<String, String> phone = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
        List<String> output = new ArrayList<String>();

        if (digits.length() != 0)
            backtrack("", digits, output, phone);

        return output;
    }

    public void backtrack(String combination, String next_digits, List<String> output, Map<String, String> phone) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1), output, phone);
            }
        }
    }
}
