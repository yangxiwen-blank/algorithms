package com.yb.string;

public class P557 {
    /**
     * 557. 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     */
    public String reverseWords(String s) {
//        StringBuilder stringBuilder = new StringBuilder();
//        StringBuilder sb = new StringBuilder();
//        for (char c : s.toCharArray()) {
//            if (c == ' ') {
//                stringBuilder.append(sb.reverse().toString());
//                stringBuilder.append(c);
//                sb.setLength(0);
//            } else
//                sb.append(c);
//        }
//        return stringBuilder.append(sb.reverse().toString()).toString();

        if (s.length() == 0 || s == null)
            return "";
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(' ' + new StringBuilder(word).reverse().toString());
        }
        return sb.delete(0, 1).toString();
    }

    /**
     * 541. 反转字符串 II<br>
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     */
    public String reverseStr(String s, int k) {
        int len = s.length();
        if (len <= k) return new StringBuilder(s).reverse().toString();

        StringBuilder res = new StringBuilder();
        StringBuilder tmp = null;
        int loc = 0;
        boolean re = true;
        // 逐位
        while (loc < len) {
            if (loc % k == 0) {
                if (tmp != null) {
                    res.append(re ? tmp.reverse().toString() : tmp.toString());
                    re = !re;
                }
                tmp = new StringBuilder();
            }
            tmp.append(s.charAt(loc));

            ++loc;
        }
        res.append(re ? tmp.reverse().toString() : tmp.toString());
        return res.toString();
    }

    public String reverseStr2(String s, int k) {
        int len = s.length();
        char[] a = s.toCharArray();

        StringBuilder res = new StringBuilder();
        StringBuilder tmp = null;
        boolean re = true;
        // 逐K位
        for (int i = 0; i < len; i += k) {
            tmp = new StringBuilder();
            tmp.append(a, i, Math.min(k, len - i));
            res.append(re ? tmp.reverse().toString() : tmp.toString());
            re = !re;
        }
        res.append(re ? tmp.reverse().toString() : tmp.toString());
        return res.toString();
    }

    public String reverseStr3(String s, int k) {
        int len = s.length();
        char[] a = s.toCharArray();

        // 逐2K位
        for (int i = 0; i < len; i += 2 * k) {
            int start = i, end = Math.min(i + k - 1, len - 1);
            while (start < end) {
                char tmp = a[start];
                a[start++] = a[end];
                a[end--] = tmp;
            }
        }
        return new String(a);
    }

    public void reverseString(char[] s) {
        if (s.length <= 1) return;
        int start = 0, end = s.length - 1;
        char tmp = s[start];
        while (start < end) {
            tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
}
