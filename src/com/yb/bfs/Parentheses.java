package com.yb.bfs;

import java.util.*;

public class Parentheses {

    /**
     * 301. 删除无效的括号<br>
     * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Deque<Character> deque = new ArrayDeque<>();
        deque.push('c');
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') continue;
        }
        return res;
    }

    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        /***
         * <pre>
         *  栈解法
         * Stack<Integer> a = new Stack<>();
         * a.push(-1);
         * for (int i = 0; i < s.length(); i++) {
         * 	char c = s.charAt(i);
         * 	if (c == '(') {
         * 		a.push(i);
         *    } else {
         * 		a.pop();
         * 		if (a.isEmpty()) {
         * 			a.push(i);
         *        } else {
         * 			max = Math.max(max, i - a.peek());
         *        }
         *    }
         * }
         * </pre>
         */

        // 动态规划
        // 初始化字符串长度的数组,默认值为0
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {// 处理每一个)
                if (s.charAt(i - 1) == '(') {// 如果前一位是(
                    dp[i] = i > 2 ? dp[i - 2] + 2 : 2; // 当前位有效长度为前2位的有效长度(如存在)+2
                } else if (i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '(') { // 如果前一位是), 判断前一位储存的有效长度前一位是(
                    // 当前位有效长度= 前一位有效长度+ 当前匹配的(前一位的有效长度(为(取默认0,为)取有效长度) + 2
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                // 取当前位最大值
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 示例：输入：n = 3 输出：[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     */
    public List<String> generateParenthesis(int n) {
        List<String> org = new ArrayList<>();
        generateParenthesisStr(n, "");
        return org;
    }

    public String generateParenthesisStr(int n, String s) {
        if (n == 0) return "";
        for (int i = 0; i < n; i++) {
//            list.add("(" + generateParenthesisStr(i, list) + ")" + generateParenthesisStr(n - 1 - i, list));
        }
        return "";
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 <br>
     * 有效字符串需满足： 左括号必须用相同类型的右括号闭合。<br>
     * 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
     */
    public boolean isValidParentheses(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> a = new Stack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    a.push(c);
                } else if ((c == ')' && a.peek() == '(') || (c == ']' && a.peek() == '[')
                        || (c == '}' && a.peek() == '{')) {
                    a.pop();
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return a.size() == 0 ? true : false;
    }
}
