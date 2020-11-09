package com.yb.string;

import java.util.Arrays;

public class P151 {
    /**
     * 151. 翻转字符串里的单词
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] ss = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; --i) {
            sb.append(ss[i]).append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
