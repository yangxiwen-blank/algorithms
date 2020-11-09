package com.yb.string;

import java.util.*;

public class Palidrom {
    /**
     * 125. 验证回文串<br>
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。<br>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        int start = 0, end = len - 1;
        char i, e;
        s = s.toLowerCase();
        while (start <= end) {
            i = s.charAt(start++);
            while (!Character.isLetterOrDigit(i) && start < len) {
                i = s.charAt(start++);
            }
            System.out.println();
            e = s.charAt(end--);
            while (!Character.isLetterOrDigit(e) && end >= 0) {
                e = s.charAt(end--);
            }
            if (i != e && Character.isLetterOrDigit(i) && Character.isLetterOrDigit(e)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 409. 最长回文串<br>
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。<br>
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。<br>
     */
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int[] si = new int[75];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                res += 2;
            } else {
                set.add(c);
            }
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            si[c - '0']++;
        }
        if (!set.isEmpty()) {
            res += 1;
        }

        for (char c : map.keySet()) {
            res += map.get(c) / 2 * 2;
            if (map.get(c) % 2 == 1 && res % 2 == 0)
                res++;
        }
        for (int i : si) {
            res += i / 2 * 2;
            if (i % 2 == 1 && res % 2 == 0)
                res++;
        }
        return res;
    }

    /**
     * 214. 最短回文串
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串
     */
    public String shortestPalindrome(String s) {
        int len = s.length();
        int left = len, right = len;
        for (int i = 0; i < len; i++) {
            int j = 1;
            // 奇数长度回文串
            while (i >= j && i + j < len - 1 && s.charAt(i - j) == s.charAt(i + j)) {
                if (j == i) {
                    left = i * 2;
                } else if (i + j == len - 1) {
                    right = i * 2 + 1;
                }
                j++;
            }

            j = 0;
            // 偶数长度回文串
            while (i >= j && i + j < len - 2 && s.charAt(i - j) == s.charAt(i + j + 1)) {
                if (j == i) {
                    left = i * 2 + 1;
                } else if (i + j == len - 2) {
                    right = i * 2;
                }
                j++;
            }
        }

        return "";
    }

    /**
     * 336. 回文对
     * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     */
    public List<List<Integer>> palindromePairs(String[] words) {

        return null;
    }

    /**
     * 647. 回文子串
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     */
    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 0) {
            return len;
        }
        boolean[] valid = new boolean[len];
        int res = 0;
        valid[0] = true;
        for (int i = 1; i < len; i++) {

            valid[i] = s.charAt(i) == s.charAt(i - 1);
        }
        return 0;
    }

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     */
    public boolean validPalindrome(String s) {
        int len = s.length();
        int start = 0, end = len - 1;
        boolean sign = true;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                /**
                 * <pre>
                 *  错在未考虑start + 1 = end 和start = end - 1 同时成立的边界值
                 * if (sign && s.charAt(start + 1) == s.charAt(end)) {
                 * 	start++;
                 * } else if (sign && s.charAt(start) == s.charAt(end - 1)) {
                 * 	end--;
                 * } else {
                 * 	return false;
                 * }
                 * sign = false;
                 * </pre>
                 */
                boolean flag1 = true, flag2 = true;
                for (int i = start, j = end - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = start + 1, j = end; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
