package com.yb;

import com.yb.tree.TreeNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Solution {
    public static HashSet<String> combination = new HashSet<>();
    public static List<String> permutation = new ArrayList<>();
    static StringBuffer s = new StringBuffer();
    static int[] ops = {0, 1, 2, 3};
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] dirx = {{-1, 0}, {1, 0}};
    public int[][] diry = {{0, -1}, {0, 1}};
    public int[][] dir8 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    List<String> res93 = new ArrayList<>();
    int[] x = new int[]{1, 0, -1, 0};
    int[] y = new int[]{0, 1, 0, -1};

    public static String decodeString(String s) {
        do {
            Pattern p = Pattern.compile("[0-9]*\\[[a-zA-Z]*\\]");
            Matcher m = p.matcher(s);
            String str = "";
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                str = m.group();
                System.out.println(str);
                m.appendReplacement(sb, test(str));
            }
            m.appendTail(sb);
            s = sb.toString();
        } while (s.split("[0-9]").length > 1);
        return s;
    }

    public static String decodeString2(String s) {
        // Stack<String> vs = new Stack<>();
        int n = s.length();
        int muti = 0;
        Stack<StringBuilder> sbs = new Stack<>();
        Stack<Integer> mutis = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                muti = muti * 10 + Integer.valueOf(c - 48);
            } else if (c == '[') {
                mutis.push(muti);
                sbs.push(sb);
                muti = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                int count = mutis.pop();
                String tmp = sb.toString();
                System.out.println("tmp:  " + tmp + "    muti:  " + count);
                for (int j = 1; j < count; j++) {
                    sb.append(tmp);
                }
                sb = sbs.pop().append(sb);
                System.out.println(sb.toString());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String test2(String s) {
        Pattern p = Pattern.compile("[0-9]*\\[[a-zA-Z]*\\]");
        Matcher m = p.matcher(s);
        String str = "";
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            str = m.group();
            System.out.println(str);
            m.appendReplacement(sb, test(str));
        }
        m.appendTail(sb);
        System.out.println(s);
        return sb.toString();
    }

    public static String test(String v) {
        String[] a = v.split("\\[");
        int i = Integer.valueOf(a[0]);
        String vStr = a[1].replace("]", "");
        String value = "";
        for (int j = 0; j < i; j++) {
            value += vStr;
        }
        return value;
    }

    public static void main(String[] args) {
        // String s = "3[qwe]1[rt]2[yu2[i3[o2[p]]a]s]1[dfg]2[hj3[jk]l]zxcvbn";
        // System.out.println(s);
        // System.out.println(decodeString2(s));
        // System.out.println(get24("A 3 7 5"));
        // 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0, 1);
        Solution solution = new Solution();
//        System.out.println(solution.findMagicIndex(new int[]{1, 2, 3, 4, 5}));
        /**
         * <pre>
         * System.out.println("2, 3, 5, 6, 8, 99, 0");
         * sollution.twoSum(new int[] { 2, 3, 5, 6, 8, 99, 0 }, 7);
         * sollution.twoSum2(new int[] { 2, 3, 5, 6, 8, 99, 0 }, 7);
         *
         * int num = 15;
         * int[] aa = new int[num];
         * Random r = new Random();
         * System.out.println("init value start");
         * for (int i = 0; i < num; i++) {
         * 	int n = r.nextInt(1000);
         * 	System.out.print(n + " ");
         * 	if (i % 100 == 0) {
         * 		System.out.println();
         *    }
         * 	aa[i] = n;
         * }
         * System.out.println("init value end");
         * sollution.threeSum(aa);
         * System.out.println(new Date().getTime());
         * System.out.println(sollution.threeSumClosest(aa, 1500));
         * System.out.println(new Date().getTime());
         * System.out.println(sollution.threeSumClosest2(aa, 1500));
         * System.out.println(new Date().getTime());
         * </pre>
         */
        // int x = 15, y = 18;
        // int[][] aa = new int[x][y];
        // Random r = new Random();
        // for (int i = 0; i < x; i++) {
        // for (int j = 0; j < y; j++) {
        // int n = r.nextInt(255);
        // System.out.print(n + " ");
        // aa[i][j] = n;
        // }
        // System.out.println();
        // }
        // sollution.imageSmoother(aa);
        // System.out.println(exam1(r.nextInt()));
        // 输入一个整数，将这个整数以字符串的形式逆序输出
        // System.out.println(exam2(r.nextInt()));
        // 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
        // System.out.println(exam3(0.5F));
        // 给定一个字符串描述的算术表达式，计算出结果值。
        // 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (,
        // )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
        // System.out.println(exam4(""));
        // 计算字符串最后一个单词的长度，单词以空格隔开。 // sc.next()自动空格分割
        Scanner sc = new Scanner(System.in);
        // String num = "";
        // for (; sc.hasNext(); num = sc.next()) {
        // }
        // System.out.println(num.length());
        // //sc.nextLine()读取整行
        // String str = sc.nextLine();
        // System.out.println(str.substring(str.lastIndexOf(" ") + 1).length());
        // “去重”与“排序” TreeSet有序且无重复的集合
        // while (sc.hasNext()) {
        // int num = sc.nextInt();
        // TreeSet<Integer> set = new TreeSet<Integer>();
        // for (int i = 0; i < num; i++) {
        // int temp = sc.nextInt();
        // set.add(temp);
        // }
        // for (Integer i : set) {
        // System.out.println(i);
        // }
        // }
        // 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
        // String str = sc.nextLine().toLowerCase();
        // String para = sc.next().toLowerCase();
        // System.out.println(str.split(para).length - 1);
        // 16进制转换
        // System.out.println(Integer.parseInt("0x1F", 16));
        // •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
        // •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
        // while (sc.hasNext()) {
        // String str = sc.nextLine();
        // while (str.length() > 7) {
        // System.out.println(str.substring(0, 8));
        // str = str.substring(str.length() > 7 ? 8 : 0);
        // }
        // if (str.length() > 0) {
        // String zStr = "00000000";
        // System.out.println(str + zStr.substring(0, 8 - str.length()));
        // }
        // }
        // 请实现如下接口
        /// * 功能：四则运算
        // * 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"
        // * 返回：算术表达式的计算结果
        // */
        // 约束：
        // pucExpression字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’
        // ,‘}’。
        // pucExpression算术表达式的有效性由调用者保证;
        // System.out.println(calculate("3+2*{1+2*[-4/(8-6)+7]}"));
        sc.close();
        // [-687153884,-854669644,-368882013,-788694078]
        // [540420176,-909203694,655002739,-577226067]
        // isRectangleOverlap(new int[] { 2, 17, 6, 20 }, new int[] { 3, 8, 12, 20 });
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec2[3] <= rec1[1] || rec2[2] <= rec1[0] || rec2[1] >= rec1[3] || rec2[0] >= rec1[2]);
        // 矩形内任何一个点在另一个矩形内 大数字崩溃(运行时间过长
        // if (rec1[0] > rec1[2]) {
        // int tmp = rec1[0];
        // rec1[0] = rec1[2];
        // rec1[2] = tmp;
        // }
        // if (rec1[1] > rec1[3]) {
        // int tmp = rec1[1];
        // rec1[1] = rec1[3];
        // rec1[3] = tmp;
        // }
        //
        // if (rec2[0] > rec2[2]) {
        // int tmp = rec2[0];
        // rec2[0] = rec2[2];
        // rec2[2] = tmp;
        // }
        // if (rec2[1] > rec2[3]) {
        // int tmp = rec2[1];
        // rec2[1] = rec2[3];
        // rec2[3] = tmp;
        // }
        //
        // for (int x = rec2[0]; x <= rec2[2]; x++) {
        // for (int y = rec2[1]; y <= rec2[3]; y++) {
        // if (isInRectangle(rec1, x, y)) {
        // System.out.println("true");
        // return true;
        // }
        // }
        // }
        //
        //// if (isInRectangle(rec1, rec2[0], rec2[1]) || isInRectangle(rec1, rec2[0],
        // rec2[3])
        //// || isInRectangle(rec1, rec2[2], rec2[1]) || isInRectangle(rec1, rec2[2],
        // rec2[3])) {
        //// System.out.println("true");
        //// return true;
        //// }
        // System.out.println("false");
        // return false;
    }

    private static boolean isInRectangle(int[] rec1, int x, int y) {
        System.out.print(rec1);
        System.out.print("   x: " + x + "   y:" + y);
        if (rec1[0] < x && rec1[2] > x && rec1[1] < y && rec1[3] > y) {
            System.out.println("     true");
            return true;
        }
        System.out.println("     false");
        return false;
    }

    private static void plzh(int[] data, int location) {
        if (location < data.length) {
            for (int i = location; i < data.length; i++) {
                int temp[] = new int[data.length];
                for (int j = 0; j < data.length; j++)
                    temp[j] = data[j];
                int loc = temp[location];
                temp[location] = temp[i];
                temp[i] = loc;
                // printCharArray(temp, location+1);
                if (location == data.length - 1) {
                    int[] op = new int[3];
                    for (int j = 0; j < ops.length; j++) {
                        op[0] = j;
                        count(temp, op, 1, op(temp[0], temp[1], ops[j]));
                    }
                    // String result = printCharArray(temp, data.length);
                    // System.out.println(new ArrayList<>(Arrays.asList(temp)));
                }
                plzh(temp, location + 1);
            }
        }
    }

    static double op(double a, double b, int opera) {
        if (opera == 0)
            return a + b;
        else if (opera == 1)
            return a - b;
        else if (opera == 2)
            return a * b;
        else if (opera == 3)
            return a / b;
        return 0;
    }

    private static void count(int[] nums, int[] op, int l, double result) {
        System.out.println(result);
        for (; l < 3; l++) {
            for (int j = 0; j < ops.length; j++) {
                op[l] = j;
                count(nums, op, l, op(result, nums[l + 1], ops[j]));
            }
        }
    }

    private static String convert(String in) throws NumberFormatException {
        if (in.equals("A")) {
            return "1";
        } else if (in.equals("J")) {
            return "11";
        } else if (in.equals("Q")) {
            return "12";
        } else if (in.equals("K")) {
            return "13";
        } else {
            return in;
        }
    }

    // 求全排列
    public static void generatePermutation(int str[], int start) {
        if (start < str.length) {
            for (int i = start; i < str.length; i++) {
                int temp[] = new int[str.length];
                for (int j = 0; j < str.length; j++)
                    temp[j] = str[j];
                // 交换第start个元素与第i个元素
                int charStart = temp[start];
                int charend = temp[i];
                temp[start] = charend;
                temp[i] = charStart;
                if (start == str.length - 1) {
                    // 只有最有一个元素时，打印字符
                    printCharArray(temp);
                }
                generatePermutation(temp, start + 1);
            }
        }
    }

    // 从M个数中取出N个数的排列
    public static void NM_Permutation(int data[], int location, int N) {
        if (N > data.length)
            return;
        if (location < N) {
            for (int i = location; i < data.length; i++) {
                int[] temp = new int[data.length];
                System.arraycopy(data, 0, temp, 0, data.length);
                int loc = temp[location];
                temp[location] = temp[i];
                temp[i] = loc;
                if (location == N - 1) {
                    String result = printCharArray(temp, N);
                    permutation.add(result);
                }
                NM_Permutation(temp, location + 1, N);
            }
        }
    }

    // 计算组合
    public static void Combination(int chars[], int N) {
        permutation.clear();
        combination.clear();
        System.out.println("************排列结果******************");
        System.out.println("************************************");
        // 计算排列
        NM_Permutation(chars, 0, N);
        for (int i = 0; i < permutation.size(); i++) {
            String resultSort = getSortArr(permutation.get(i));
            combination.add(resultSort);
            System.out.println(resultSort);
        }
        System.out.println();
        System.out.println("************组合结果******************");
        System.out.println("************************************");
        Iterator data = combination.iterator();
        while (data.hasNext()) {
            System.out.println(data.next());
        }
    }

    public static void printCharArray(int chars[]) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            str.append(chars[i]);
        }
        System.out.println(str.toString());
    }

    public static String printCharArray(int chars[], int N) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < N; i++) {
            str.append(chars[i]);
        }
        System.out.println(str.toString());
        return str.toString();
    }

    public static String getSortArr(String str) {
        char datas[] = str.toCharArray();
        Arrays.sort(datas);
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < datas.length; i++)
            result.append(datas[i]);
        return result.toString();
    }

    public static void printArray(int chars[]) {
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    private static int exam3(float f) {
        return f % 1 >= 0.5 ? (int) f / 1 + 1 : (int) f / 1;
    }

    public static int calculate(String strExpression) {
        // 创建 Pattern 对象
        Pattern r = Pattern.compile("\\(\\-?\\d+\\+|\\-|\\*|\\/\\-?d+\\)");
        // 现在创建 matcher 对象
        Matcher m = r.matcher(strExpression);
        System.out.println(m.matches());
        System.out.println(m.groupCount());
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
        }
        return 0;
    }

    public static double op(double n1, double n2, char opera) {
        if (opera == '-') {
            return n1 - n2;
        }
        if (opera == '+') {
            return n1 + n2;
        }
        if (opera == '*') {
            return n1 * n2;
        }
        if (opera == '/') {
            return n1 / n2;
        }
        return 0;
    }

    private static String StringBufferFastThanString(int n) {
        char[] str = ("" + n).toCharArray();
        // String result = "";
        // for (int i = str.length; i > 0; i--) {
        // result += str[i - 1];
        // }
        // return result;
        // StringBuffer 比字符串拼接速度快
        StringBuffer result = new StringBuffer();
        for (int i = str.length; i > 0; i--) {
            result.append(str[i - 1]);
        }
        return result.toString();
    }

    private static int exam1(Integer n) {
        System.out.println(n);
        int result = 0;
        // 二进制字符串
        // String bStr = Integer.toBinaryString(n);
        // System.out.println(bStr);
        // for (char c : bStr.toCharArray()) {
        // if (c == '1') {
        // result++;
        // }
        // }
        // >> 位运算符
        while (n > 0) {
            if ((n & 1) > 0) {
                result++;
            }
            n = n >> 1;
        }
        return result;
    }

    /**
     * 679. 24 点游戏
     * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
     */
    public boolean judgePoint24(int[] nums) {
        for (int i = 0; i < 4; i++) {
            judgePoint24(nums, i, 4);
        }
        return false;
    }

    public boolean judgePoint24(int[] nums, int num, int len) {
        int count = 2;
        for (int i = 0; i < len; i++) {
            if (i < num) {
                for (int j = 2; j < 4; j++) {
                    op(nums[num], nums[i], ops[j]);
                }
            }
            if (i == num) continue;
            if (i > num) {
                for (int j = 0; j < 4; j++) {
                    op(nums[num], nums[i], ops[j]);
                }
            }
        }
        return false;
    }



    /**
     * 5501. 使陆地分离的最少天数
     * 给你一个由若干 0 和 1 组成的二维网格 grid ，其中 0 表示水，而 1 表示陆地。岛屿由水平方向或竖直方向上相邻的 1 （陆地）连接形成。
     * 如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。
     * 一天内，可以将任何单个陆地单元（1）更改为水单元（0）。
     * 返回使陆地分离的最少天数。
     */
    public int minDays(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] visited = new int[r][c];
        int num = 0;
        int count = check5501(grid, visited, num++);
        //网格中都是水，也认为是分离的
        if (count != 1) return 0;
        // 只有1座岛屿（visited 值都为1）
        // 桥
        int bridge = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) continue;
                grid[i][j] = 0;
                if (check5501(grid, visited, num++) != 1) return 1;
                ++visited[i][j];
                grid[i][j] = 1;
//                if (grid[i][j] == 1 ) {
//                    //连通量
//                    int connectx = 0;
//                    int connecty = 0;
//                    for (int[] dir : dirx) {
//                        int nr = i + dir[0];
//                        if (nr >= 0 && nr < grid.length && grid[nr][j] == 1)
//                            ++connectx;
//                    }
//                    for (int[] dir : diry) {
//                        int nc = j + dir[1];
//                        if (nc >= 0 && nc < grid[0].length && grid[i][nc] == 1)
//                            ++connecty;
//                    }
//                    // 如果有土地只与另一块土地相连
//                    if (connectx + connecty == 1) {
//                        return 1;
//                    }
//
//                    if ((connectx == 2 && connecty == 0) || (connecty == 2 && connectx == 0)) ++bridge;
//                }
            }
        }
//        if (bridge == 1) return 1;
        // 其他情况
        return 2;
    }

    private int check5501(int[][] grid, int[][] visited, int n) {
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && visited[i][j] == n) {
                    ++count;
                    dfs5501(grid, visited, i, j, n);
                    // 如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则(<1||>1)，陆地就是 分离的 。
                    if (count > 1) return count;
                }
            }
        }
        return count;
    }

    private void dfs5501(int[][] grid, int[][] visited, int i, int j, int n) {
        if (visited[i][j] > n)
            return;
        ++visited[i][j];
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1)
                dfs5501(grid, visited, nr, nc, n);
        }
    }

    public int removeDuplicates(int[] nums) {
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

    /**
     * 85. 最大矩形
     * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int r0 = matrix.length;
        int c0 = matrix[0].length;
        int res = 0;
        int[][] dp = new int[r0][c0];
        int count;
        int[] col = new int[c0];
        int[][] area = new int[r0][c0];
        for (int i = 0; i < r0; i++) {
            count = 0;
            for (int j = 0; j < c0; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    count = 0;
                    continue;
                }
                ++count;
                ++col[j];
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
//                    if (dp[i][j] > 1 && (dp[i][j] == dp[i - 1][j] || dp[i][j] == dp[i][j - 1])) {
//                        if (area[i - 1][j] != 0) {
//                            area[i][j] = area[i - 1][j] + dp[i][j];
//                        } else if (area[i][j - 1] != 0) {
//                            area[i][j] = area[i][j - 1] + dp[i][j];
//                        } else {
//                            area[i][j] = dp[i][j] * (dp[i][j] + 1);
//                        }
//                    }
                    if (dp[i][j] > 1 && dp[i][j] != dp[i - 1][j - 1]) {
                        if (dp[i][j] == dp[i - 1][j]) {
                            if (area[i - 1][j] != 0) {
                                area[i][j] = area[i - 1][j] + dp[i][j];
                            } else {
                                area[i][j] = dp[i][j] * (dp[i][j] + 1);
                            }
                        }
                        if (dp[i][j] == dp[i][j - 1]) {
                            if (area[i][j - 1] != 0) {
                                area[i][j] = area[i][j - 1] + dp[i][j];
                            } else {
                                area[i][j] = dp[i][j] * (dp[i][j] + 1);
                            }
                        }
                    }
                }
                res = Math.max(res, area[i][j]);
                res = Math.max(res, dp[i][j] * dp[i][j]);
                res = Math.max(res, count);
                res = Math.max(res, col[j]);
            }
        }
        return res;
    }

    /**
     * 406. 根据身高重建队列
     * 假设有打乱顺序的一群人站成一个队列。
     * 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
     * 编写一个算法来重建这个队列。
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //先按身高逆序，身高相同按k顺序
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }
        int n = people.length;
        return output.toArray(new int[n][2]);
    }

    /**
     * 459. 重复的子字符串
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        boolean res = false;
        char[] cs = s.toCharArray();
//        for (int i = 1, len = s.length(); i < len; i++) {
//            if (cs[i] == cs[0]) {
//                int src = i;
//                for (int j = 1; j <= src; j++) {
//                    if (cs[i + j] == cs[j]) {
//
//                    }
//                }
//            }
//        }
        // 一句代码写法
        //return (s+s).indexOf(s, 1) != s.length();
        //TODO KMP算法待学习
        // i:子串长度
        for (int i = len / 2; i > 0; i--) {
            //如果可以整除
            if (len % i == 0) {
                res = true;
                // 子串重复次数
                int count = len / i;
                // j: 子串循环位数
                for (int j = 0; j < i; j++) {
                    // k: 第k个子串
                    for (int k = 1; k < count; k++) {
                        if (cs[j] != cs[i * k + j]) {
                            // 如果当前字符不等，退出
                            res = false;
                            break;
                        }
                    }
                    if (!res) break;
                }
                if (res) return res;
            }
        }
        return res;
    }

    /**
     * 632. 最小区间
     * 你有 k (1 <= k <= 3500)个升序排列的整数列表。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
     * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Integer> deque = new PriorityQueue();
        int min = 0, max = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
            }
        }
        return new int[]{min, max};
    }

    /**
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有
     * 最多 的糖果数目。
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; ++i) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> ret = new ArrayList<Boolean>();
        for (int i = 0; i < n; ++i) {
            ret.add(candies[i] + extraCandies >= maxCandies);
        }
        return ret;
    }

    public int[][] imageSmoother(int[][] M) {
        if (M == null) {
            return null;
        }
        if (M.length == 0) {
            return new int[][]{};
        }
        int l1 = M.length;
        int l2 = M[0].length;
        int[][] ans = new int[l1][l2];
        for (int r = 0; r < l1; r++) {
            System.out.println();
            for (int c = 0; c < l2; c++) {
                int count = 0;
                for (int nr = r - 1; nr <= r + 1; ++nr)
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= nr && nr < l1 && 0 <= nc && nc < l2) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                System.out.print(ans[r][c] + ":" + count + " ");
                ans[r][c] /= count;
                /***
                 * <pre>
                 * int sum = M[r][c];
                 * count = 1;
                 *
                 * if (r > 0) {
                 * 	if (c > 0) {
                 * 		sum += M[r - 1][c - 1];
                 * 		count += 1;
                 *    }
                 * 	sum += M[r - 1][c];
                 * 	count += 1;
                 * 	if (c < l2 - 1) {
                 * 		sum += M[r - 1][c + 1];
                 * 		count += 1;
                 *    }
                 * }
                 * if (c > 0) {
                 * 	sum += M[r][c - 1];
                 * 	count += 1;
                 * }
                 * if (c < l2 - 1) {
                 * 	sum += M[r][c + 1];
                 * 	count += 1;
                 * }
                 * if (r < l1 - 1) {
                 * 	if (c > 0) {
                 * 		sum += M[r + 1][c - 1];
                 * 		count += 1;
                 *    }
                 * 	sum += M[r + 1][c];
                 * 	count += 1;
                 * 	if (c < l2 - 1) {
                 * 		sum += M[r + 1][c + 1];
                 * 		count += 1;
                 *    }
                 * }
                 * System.out.print(sum + ":" + count + "|");
                 * ans[r][c] = sum / count;
                 * System.out.println();
                 * </pre>
                 */
            }
        }
        return ans;
    }

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中
     * output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        /** 除法 */
        int sum = 1;
        boolean has0 = false;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0 && !has0) {
                has0 = true;
            } else if (nums[i] == 0 && has0) {
                return new int[length];
            } else
                sum *= nums[i];
        }
        for (int i = 0; i < length; i++) {
            if (has0) {
                nums[i] = nums[i] == 0 ? sum : 0;
            } else {
                nums[i] = sum / nums[i];
            }
        }
        // return nums;
        /** 两侧相乘法 原始 */
        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];
        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }
        // return answer;
        int left[] = new int[length];
        int right[] = new int[length];
        left[0] = nums[0];
        right[length - 1] = nums[length - 1];
        for (int i = 1; i < length - 1; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        left[length - 1] = left[length - 2];
        for (int i = length - 2; i > 0; i--) {
            right[i] = right[i + 1] * nums[i];
            left[i] = left[i - 1] * right[i + 1];
        }
        return left;
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 1) {
            return 0;
        }
        int high = height[0], value = 0;
        int[] left = new int[len];
        for (int i = 1; i < len; i++) {
            if (high > height[i]) {
                left[i] = high - height[i];
            } else {
                high = height[i];
            }
        }
        high = height[len - 1];
        for (int i = len - 2; i > 0; i--) {
            if (high > height[i]) {
                value += Math.min(left[i], high - height[i]);
            } else {
                high = height[i];
            }
        }
        System.out.println("解法一(左右两次循环): " + value);
        int left2 = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left2 < right) {
            if (height[left2] < height[right]) {
                if (height[left2] >= left_max) {
                    left_max = height[left2];
                } else {
                    ans += (left_max - height[left2]);
                }
                left2++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                right--;
            }
        }
        System.out.println("解法二(双指针单循环): " + ans);
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            // 如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; // 取出要出栈的元素
                stack.pop(); // 出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; // 两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); // 当前指向的墙入栈
            current++; // 指针后移
        }
        System.out.println("解法三(栈): " + sum);
        return value;
    }

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        // double[] dp = new double[K + W];
        // for (int i = K; i <= N && i < K + W; i++) {
        // dp[i] = 1.0;
        // }
        // for (int i = K - 1; i >= 0; i--) {
        // for (int j = 1; j <= W; j++) {
        // dp[i] += dp[i + j] / W;
        // System.out.println("dp[" + i + "]:" + dp[i]);
        // }
        // }
        // https://leetcode-cn.com/problems/new-21-game/solution/huan-you-bi-zhe-geng-jian-dan-de-ti-jie-ma-tian-ge/
        double[] dp = new double[K + W];
        double s = 0.0;
        for (int i = K; i < K + W; i++) {
            dp[i] = i <= N ? 1 : 0;
            s += dp[i];
        }
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = s / W;
            System.out.println("dp[" + i + "]:" + dp[i]);
            s = s - dp[i + W] + dp[i];
        }
        return dp[0];
    }

    public int quickMulti(int A, int B) {
        int ans = 0;
        for (; B > 0; B >>= 1) {
            if ((B & 1) > 0) {
                ans += A;
            }
            A <<= 1;
        }
        return ans;
    }

    /**
     * 54. 螺旋矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    public int[] spiralOrder(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return new int[]{};
        }
        int h = matrix[0].length;
        int[] rv = new int[len * h];
        int c = 0;
        int left = 0, right = h - 1, top = 0, bottom = len - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                rv[c++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                rv[c++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    rv[c++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    rv[c++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return rv;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return new ArrayList();
        }
        int h = matrix[0].length;
        List<Integer> rv = new ArrayList();
        int left = 0, right = h - 1, top = 0, bottom = len - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                rv.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                rv.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    rv.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    rv.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return rv;
    }

    /**
     * 59. 螺旋矩阵II
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bot = n - 1;
        int i = 1;
        while (i <= n * n) {
            for (int r = top, c = left; c <= right; c++) {
                res[r][c] = i++;
            }
            top++;
            for (int r = top, c = right; r <= bot; r++) {
                res[r][c] = i++;
            }
            right--;
            for (int r = bot, c = right; c >= left; c--) {
                res[r][c] = i++;
            }
            bot--;
            for (int r = bot, c = left; r >= top; r--) {
                res[r][c] = i++;
            }
            left++;
        }
        return res;
    }

    /**
     * 885. 螺旋矩阵 III
     * 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始
     * 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
     * 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
     * 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
     * 最终，我们到过网格的所有 R * C 个空间。
     * 按照访问顺序返回表示网格位置的坐标列表。
     */
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int left = c0, right = c0 + 1, top = r0, bot = r0 + 1;
        int r, c;
        int i = 0;
        while (i < R * C) {
            for (r = top, c = Math.max(left, 0), left--; c <= Math.min(right, C - 1) && r >= 0; c++) {
                res[i][0] = r;
                res[i++][1] = c;
            }
            if (i == R * C) {
                break;
            }
            for (r = Math.max(top, -1) + 1, c = right; r <= Math.min(bot, R - 1) && c < C; r++) {
                res[i][0] = r;
                res[i++][1] = c;
            }
            if (i == R * C) {
                break;
            }
            for (r = bot, c = Math.min(right, C) - 1, right++; c >= Math.max(left, 0) && r < R; c--) {
                res[i][0] = r;
                res[i++][1] = c;
            }
            if (i == R * C) {
                break;
            }
            for (r = Math.min(bot, R) - 1, bot++, c = left; r >= Math.max(top, 0) && c >= 0; r--) {
                res[i][0] = r;
                res[i++][1] = c;
            }
            top--;
        }
        return res;
    }

    /**
     * 38. 外观数列
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
     * 注意：整数序列中的每一项将表示为一个字符串。
     */
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = describeStr(res);
            System.out.println(i + " : " + res);
        }
        return res;
    }

    private String describeStr(String res) {
        StringBuilder sb = new StringBuilder();
        char r = res.charAt(0);
        int count = 0;
        for (char c : res.toCharArray()) {
            if (r == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(r);
                r = c;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(r);
        return sb.toString();
    }

    /**
     * 130. 被围绕的区域
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     */
    public void solve(char[][] board) {
        if (board.length <= 2) return;
        if (board[0].length <= 2) return;
        // 记录已访问 联通至外圈的O
        int[][] visited = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            visit(board, visited, r, 0);
            visit(board, visited, r, board[0].length - 1);
        }
        for (int c = 0; c < board[0].length; c++) {
            visit(board, visited, 0, c);
            visit(board, visited, board.length - 1, c);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (visited[i][j] == 1 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void visit(char[][] board, int[][] visited, int r, int c) {
        if (board[r][c] == 'X' || visited[r][c] == 1) {
            return;
        }
        visited[r][c] = 1;
        if (r > 0) visit(board, visited, r - 1, c);
        if (r < board.length - 1) visit(board, visited, r + 1, c);
        if (c > 0) visit(board, visited, r, c - 1);
        if (c < board[0].length - 1) visit(board, visited, r, c + 1);
    }

    /**
     * 696. 计数二进制子串
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     * 重复出现的子串要计算它们出现的次数。
     */
    public int countBinarySubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 直接计数
        int count = 0;
        int zCount = 0;
        int res = 0;
        char[] cs = s.toCharArray();
        char c = cs[0];
        for (char t : cs) {
            if (t == c) {
                zCount++;
            } else {
                if (count != 0) {
                    res += Math.min(count, zCount);
                }
                c = t;
                count = zCount;
                zCount = 1;
            }
        }
        res += Math.min(count, zCount);
        // 数组
        count = 0;
        int[] l = new int[s.length()];
        for (char t : cs) {
            if (t != c) {
                c = t;
                count++;
            }
            l[count]++;
        }
        res = 0;
        for (int i = 1; i < l.length; i++) {
            if (l[i] == 0) {
                break;
            }
            res += Math.min(l[i - 1], l[i]);
        }
        return res;
    }

    /**
     * 93. 复原IP地址
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     */
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len < 4 || len > 12) {
            return new ArrayList<>();
        }
        int[] nums = new int[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            nums[i++] = c - 48;
        }
        restoreIpAddresses(nums, new StringBuilder(), 0, 0, len);
        return res93;
    }

    private void restoreIpAddresses(int[] nums, StringBuilder sb, int s, int e, int len) {
        if (e == 4) {
            if (s == len) {
                res93.add(sb.toString());
            }
            return;
        }
        if (sb.length() != 0)
            sb.append('.');
        int n1 = 0, n2 = 0, n3 = 0;
        if (s < len) {
            n1 = nums[s];
            restoreIpAddresses(nums, new StringBuilder(sb).append(nums[s]), s + 1, e + 1, len);
            if (n1 == 0)
                return;
        }
        if (s < len - 1) {
            n2 = nums[s + 1];
            restoreIpAddresses(nums, new StringBuilder(sb).append(nums[s]).append(nums[s + 1]), s + 2, e + 1, len);
        }
        if (s < len - 2) {
            n3 = nums[s + 2];
            if (n1 * 100 + n2 * 10 + n3 <= 255)
                restoreIpAddresses(nums, new StringBuilder(sb).append(nums[s]).append(nums[s + 1]).append(nums[s + 2]), s + 3, e + 1, len);
        }
    }

    /**
     * 99. 恢复二叉搜索树
     * 二叉搜索树（它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；）中的<b>两个节点</b>被错误地交换。
     * 请在不改变其结构的情况下，恢复这棵树。
     */
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] wrongPair = findTwoSwapped(nums);
        recover(root, 2, wrongPair[0], wrongPair[1]);
        // 以下脑残
        TreeNode tmp = new TreeNode(0);
        if (root.left != null) {
            recoverTree(root.left);
            if (root.val < root.left.val)
                swapTreeNodeLeft(root, root.left, tmp);
        }
        if (root.right != null) {
            recoverTree(root.right);
            if (root.val > root.right.val)
                swapTreeNodeRight(root, root.left, tmp);
        }
        root = tmp.left;
        // 以上脑残
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root == null) return;
        if (root.val == x || root.val == y) {
            root.val = root.val == x ? y : x;
            if (--count == 0) {
                return;
            }
        }
        recover(root.right, count, x, y);
        recover(root.left, count, x, y);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    private void swapTreeNodeLeft(TreeNode root, TreeNode left, TreeNode tmp) {
        tmp.left = left;
        tmp.right = root.right;
        root.left = left.left;
        root.right = left.right;
        tmp.left.left = root;
        tmp.left.right = tmp.right;
    }

    private void swapTreeNodeRight(TreeNode root, TreeNode left, TreeNode tmp) {
        tmp.left = left;
        tmp.right = root.left;
        root.left = left.left;
        root.right = left.right;
        tmp.left.right = root;
        tmp.left.left = tmp.right;
    }

    /**
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b"
     * 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     * <p>
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 <br>
     * 提示： <br>
     * 1 <= equations.length <= 500<br>
     * equations[i].length == 4<br>
     * equations[i][0] 和 equations[i][3] 是小写字母<br>
     * equations[i][1] 要么是 '='，要么是 '!'<br>
     * equations[i][2] 是 '='<br>
     */
    public boolean equationsPossible(String[] equations) {
        /**
         * 错误解法
         *
         * <pre>
         * List<HashSet<Character>> equal = new Vector<HashSet<Character>>();
         * boolean contain = false;
         * for (int i = 0; i < equations.length; i++) {
         * 	if (equations[i].charAt(1) == '=') {
         * 		char c0 = equations[i].charAt(0);
         * 		char c3 = equations[i].charAt(3);
         * 		contain = false;
         * 		for (HashSet<Character> set : equal) {
         * 			if (set.contains(c0) || set.contains(c3)) {
         * 				set.add(c0);
         * 				set.add(c3);
         * 				contain = true;
         * 				break;
         *            }
         *        }
         * 		if (!contain) {
         * 			HashSet<Character> set = new HashSet<Character>();
         * 			set.add(c0);
         * 			set.add(c3);
         * 			equal.add(set);
         *        }
         *    }
         * }
         *
         * for (int i = 0; i < equations.length; i++) {
         * 	if (equations[i].charAt(1) == '!') {
         * 		char c0 = equations[i].charAt(0);
         * 		char c3 = equations[i].charAt(3);
         * 		if (c0 == c3) {
         * 			return false;
         *        }
         * 		for (HashSet<Character> set : equal) {
         * 			if (set.contains(c0) && set.contains(c3)) {
         * 				return false;
         *            }
         *        }
         *    }
         * }
         * return true;
         * </pre>
         */
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     */
    public int jump(int[] nums) {
        int len = nums.length;
        // int[] tmp = new int[len];
        int maxPosition = nums[0];
        int pos = 0;
        int steps = 0;
        for (int i = 0; i < len; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == pos) {
                System.out.println("第 " + steps + " 次跳跃,跳到 " + i);
                pos = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * P84 柱状图中的最大矩形
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     */
    public int largestRectangleArea(int[] heights) {
        // TODO
//        int high = 0, low = Integer.MAX_VALUE, max = 0;
//        for (int i = 0; i < heights.length; i++) {
//            for (int j = 0; j < ; ++j) {
//
//            }
//            low = Math.min(low, heights[i]);
//            high = Math.max(high, heights[i]);
//            max = Math.max(max, low * (i + 1));
//        }
        int res = 0;
        int len = heights.length;
        for (int i = 0; i < len; ++i) {
            int max = heights[i], low = heights[i];
            for (int j = i + 1; j < len; ++j) {
                low = Math.min(low, heights[j]);
                max = Math.max(max, low * (j - i));
            }
            res = Math.max(res, max);
        }
        return res;
    }

    /**
     * 200. 岛屿数量
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        int[][] visited = new int[r][c];
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    dfs200(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs200(char[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && visited[x][y] == 0)
                dfs200(grid, visited, x, y);
        }
    }

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成
     * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 输入: 12258 输出: 5 解释: 121258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return translateNum(num / 10) + translateNum(num / 100);
        } else {
            return translateNum(num / 10);
        }
    }

    private boolean oneChanged(String beginWord, String curWord) {
        int count = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != curWord.charAt(i)) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return count == 1;
    }

    /**
     * 给定两个 没有重复元素 的数组 nums1
     * 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        // 暴力
        for (int i = 0; i < nums1.length; i++) {
            int v = -1;
            boolean sign = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    sign = true;
                }
                if (sign && nums2[j] > nums1[i]) {
                    v = nums2[j];
                    break;
                }
            }
            res[i] = v;
        }
        return res;
    }

    /**
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4,
     * 2, 1, 1, 0, 0]。
     * <p>
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count = 1;
            while (!stack.empty() && T[i] > stack.peek()) {
                if (stack.pop() == 0)
                    count++;
                else
                    res[i - count] = count++;
            }
            if (!stack.empty()) {
                for (int j = 1; j < count; j++) {
                    stack.push(0);
                }
            }
            // map.put(stack.pop(), T[i]);
            stack.push(T[i]);
        }
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack2 = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack2.isEmpty() && temperature > T[stack2.peek()]) {
                int prevIndex = stack2.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack2.push(i);
        }
        return res;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现(两次)。找出那个只出现了一次的元素。
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * 给定一个非空整数数组，除了恰好有两个只出现一次以外，其余每个元素均出现(两次)。找出那个只出现了一次的元素。
     */
    public int[] singleNumber2(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = xor & (-xor);
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & mask) != 0) {
                ans[0] ^= num;
            }
        }
        ans[1] = xor ^ ans[0];
        return ans;
    }

    /**
     * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。
     * 其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
     * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）： <br>
     * (x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
     * <p>
     * 如果我们的地图上只有陆地或者海洋，请返回 -1。
     */
    public int maxDistance(int[][] grid) {
        // 方法1 动态规划
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int len = grid.length;
        Queue<int[]> stack = new ArrayDeque<int[]>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    stack.offer(new int[]{i, j});
                }
            }
        }
        boolean has = false;
        int[] point = null;
        while (!stack.isEmpty()) {
            point = stack.poll();
            for (int i = 0; i < 4; i++) {
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];
                if (x < 0 || y < 0 || x > len - 1 || y > len - 1 || grid[x][y] > 0) {
                    continue;
                }
                grid[x][y] = grid[point[0]][point[1]] + 1;
                has = true;
                stack.offer(new int[]{x, y});
            }
        }
        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !has) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }

    /**
     * 给定一副牌，每张牌上都写着一个整数。<br>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：<br>
     * 每组都有 X 张牌。 组内所有的牌上都写着相同的整数。 仅当你可选的 X >= 2 时返回 true。 提示： 1 <= deck.length <=
     * 10000 0 <= deck[i] < 10000
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        int[] count = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            count[deck[i]]++;
        }
        int g = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                continue;
            if (g == -1)
                g = count[i];
            else
                g = gcd(g, count[i]);
            if (g == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 一行代码求最大公约数
     */
    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public int[] sortArray(int[] nums) {
        /** 排序 */
        // Arrays.sort(nums);
        int i = 0, len = nums.length;
        int[] res = new int[len];
        while (i < len / 2) {
            int low = i, high = i;
            for (int j = i + 1; j < nums.length - i; j++) {
                if (nums[j] > nums[high]) {
                    high = j;
                }
                if (nums[j] < nums[low]) {
                    low = j;
                }
            }
            res[i] = nums[low];
            swap(nums, i, low);
            if (len - 1 - i != i) {
                res[len - 1 - i] = nums[high];
                swap(nums, len - 1 - i, high);
            }
            i++;
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。 <br>
     * 要求算法的时间复杂度为 O(n)。 <br>
     * 示例: 输入: [100, 4, 200, 1, 3, 2] 输出: 4 <br>
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (Integer integer : set) {
            if (set.contains(integer - 1)) {
                continue;
            }
            int cur = 1;
            while (set.contains(integer + cur)) {
                cur++;
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 递归(优化空间占用)
         *
         * <pre>
         * if (l1 == null) {
         * 	return l2;
         * } else if (l2 == null) {
         * 	return l1;
         * } else if (l1.val < l2.val) {
         * 	l1.next = mergeTwoLists(l1.next, l2);
         * 	return l1;
         * } else {
         * 	l2.next = mergeTwoLists(l1, l2.next);
         * 	return l2;
         * }
         * </pre>
         */
        // 迭代(没想好写法的做法)(抄的)
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
        /**
         * 递归 (原版代码)
         *
         * <pre>
         * public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         * 	ListNode res = new ListNode();
         * 	merge(res, l1, l2);
         * 	return res.next;
         * }
         *
         * private void merge(ListNode res, ListNode l1, ListNode l2) {
         * 	if (l1 == null) {
         * 		res.next = l2;
         * 		return;
         *    }
         * 	if (l2 == null) {
         * 		res.next = l1;
         * 		return;
         *    }
         * 	if (l1.val < l2.val) {
         * 		res.next = l1;
         * 		merge(res.next, l1.next, l2);
         *    } else {
         * 		res.next = l2;
         * 		merge(res.next, l1, l2.next);
         *    }
         * }
         * </pre>
         */
    }

    /**
     * 给定一个链表，删除链表的***倒数***第 n 个节点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prevHead = new ListNode();
        ListNode prev = prevHead;
        ListNode nth = head;
        for (int i = 1; i < n; i++) {
            nth = nth.next;
        }
        while (nth.next != null) {
            prev.next = head;
            head = head.next;
            nth = nth.next;
            prev = prev.next;
        }
        prev.next = head.next;
        return prevHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        // ListNode res = lists[0];
        // for (int i = 1; i < len; i++) {
        // res = mergeTwoLists(lists[i], res);
        // }
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (true) {
            int min = Integer.MAX_VALUE;
            int c = -1;
            for (int i = 0; i < len; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    c = i;
                }
            }
            if (c == -1) {
                break;
            }
            prev.next = lists[c];
            prev = prev.next;
            lists[c] = lists[c].next;
        }
        return prehead.next;
    }

    /**
     * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
     * <p>
     * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和***减去***它们两者之间的距离。
     * <p>
     * 返回一对观光景点能取得的最高分。 提示：
     * <p>
     * 2 <= A.length <= 50000 1 <= A[i] <= 1000
     */
    public int maxScoreSightseeingPair(int[] A) {
        /**
         * 脑残版错误代码
         *
         * <pre>
         * int min = 50000, max = 1;
         * Map<Integer, List<Integer>> map = new HashMap<>();
         * for (int i = 0; i < A.length; i++) {
         * 	if (map.containsKey(A[i])) {
         * 		map.get(A[i]).add(i);
         *    } else {
         * 		List<Integer> li = new ArrayList<Integer>();
         * 		li.add(i);
         * 		map.put(A[i], li);
         *    }
         * 	max = Math.max(max, A[i]);
         * }
         * int ov = max, nv = 0;
         * List<Integer> old = map.remove(max--);
         * int res = 0;
         * while (true) {
         * 	while (!map.containsKey(max) && max >= 1) {
         * 		max--;
         *    }
         * 	nv = max;
         * 	List<Integer> ne = map.remove(max--);
         * 	for (int i = 0; i < old.size(); i++) {
         * 		if (i > 0) {
         * 			min = Math.min(Math.abs(old.get(i) - old.get(i - 1)), min);
         * 			if (min == 1) {
         * 				return ov * 2 - min;
         *            }
         * 			res = Math.max(ov + ov - Math.abs(old.get(i) - old.get(i - 1)), res);
         *        }
         * 		int ns = ne != null ? ne.size() : 0;
         * 		for (int j = 0; j < ns; j++) {
         * 			res = Math.max(ov + nv - Math.abs(old.get(i) - ne.get(j)), res);
         *        }
         *    }
         * 	ov = nv;
         * 	if (map.size() == 0) {
         * 		break;
         *    }
         * }
         * return res;
         * </pre>
         */
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    public ListNode swapPairs(ListNode head) {
        // 循环
        ListNode rhead = new ListNode();
        rhead.next = head;
        ListNode tmp = rhead;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode cur = new ListNode(tmp.next.val);
            // 增删操作
            tmp.next = tmp.next.next;
            tmp = tmp.next;
            cur.next = tmp.next;
            tmp.next = cur;
            tmp = tmp.next;
        }
        /**
         * 递归
         *
         * <pre>
         * // If the list has no node or has only one node left.
         * if ((head == null) || (head.next == null)) {
         * 	return head;
         * }
         * // Nodes to be swapped
         * ListNode firstNode = head;
         * ListNode secondNode = head.next;
         * // Swapping
         * firstNode.next = swapPairs(secondNode.next);
         * secondNode.next = firstNode;
         * // Now the head is the second node
         * return secondNode;
         * </pre>
         */
        return rhead.next;
    }

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。<br>
     * k 是一个正整数，它的值小于或等于链表的长度。<br>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 剩余的节点保持原有顺序
        int i = 1;
        ListNode tmp = head;
        for (; tmp.next != null && i < k; tmp = tmp.next) {
            i++;
            System.out.println("i : " + i);
        }
        if (i < k)
            return head;
        // 返回翻转后的链表
        ListNode top = null;
        ListNode prev = null;
        i = 1;
        while (head != null) {
            System.out.println("head.val  : " + head.val);
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            if (top == null) {
                top = prev;
            }
            if (i == k) {
                top.next = reverseKGroup(head, k);
                break;
            }
            i++;
        }
        return prev;
    }

    /**
     * 我们从二叉树的根节点 root 开始进行深度优先搜索。
     * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D +
     * 1。根节点的深度为 0）。
     * 如果节点只有一个子节点，那么保证该子节点为左子节点。 给出遍历输出 S，还原树并返回其根节点 root。
     * 提示： 原始树中的节点数介于 1 和 1000 之间。 每个节点的值介于 1 和 10 ^ 9 之间。
     */
    public TreeNode recoverFromPreorder(String S) {
        // TODO
        return null;
    }

    public int strStr(String haystack, String needle) {
        int l = needle.length();
        int len = haystack.length();
        // if (l > len) {
        // return -1;
        // }
        int res = -1;
        for (int i = 0; i <= len - l; i++) {
            if (haystack.substring(i, i + l).equals(needle)) {
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。<br>
     * 返回被除数 dividend 除以除数 divisor 得到的商。<br>
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     */
    public int divide(int dividend, int divisor) {
        // TODO
        return 0;
    }

    /**
     * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
     * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
     * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
     */
    public boolean patternMatching(String pattern, String value) {
        int pl = pattern.length();
        int vl = value.length();
        int ac = 0;
        int bc = 0;
        for (int i = 0; i < pl; i++) {
            if (pattern.charAt(i) == 'a') {
                ac++;
            } else {
                bc++;
            }
        }
        if (ac == 0 && bc == 0) {
            if (vl == 0) {
                return true;
            } else {
                return false;
            }
        }
        int i = 0, al = 0, bl = 0, tmp = 0;
        char[] cvalue = value.toCharArray();
        char[] cpattern = pattern.toCharArray();
        while (ac * i <= vl) {
            tmp = ac * i;
            if (bc == 0 && tmp == vl) {
                al = i;
                // if ()
            } else if ((vl - tmp) % bc == 0) {
                al = i;
                bl = (vl - tmp) / bc;
            } else {
                i++;
                continue;
            }
            i++;
        }
        return false;
    }

    public boolean isMatch(char[] pattern, char[] value, int al, int bl) {
        int len = pattern.length;
        for (int i = 0; i < len; i++) {
            while (true) {
                break;
            }
        }
        return true;
    }

    /**
     * 67 二进制求和
     */
    public String addBinary(String a, String b) {
        int len = a.length();
        int len2 = b.length();
        int l = Math.max(len, len2);
        int i = 0;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        System.out.println(a);
        System.out.println(b);
        while (l > i) {
            int ac = i < len ? a.charAt(len - 1 - i) - 48 : 0;
            int bc = i < len2 ? b.charAt(len2 - 1 - i) - 48 : 0;
            int v = ac + bc + add;
            if (v > 1) {
                v = v - 2;
                add = 1;
            } else {
                add = 0;
            }
            sb.append(v);
            i++;
        }
        if (add == 1) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }

    /**
     * 415. 字符串相加<br>
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     */
    public String addStrings(String a, String b) {
        int len = a.length();
        int len2 = b.length();
        int l = Math.max(len, len2);
        int i = 0;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (l > i) {
            int ac = i < len ? a.charAt(len - 1 - i) - 48 : 0;
            int bc = i < len2 ? b.charAt(len2 - 1 - i) - 48 : 0;
            int v = ac + bc + add;
            if (v > 9) {
                v = v % 10;
                add = 1;
            } else {
                add = 0;
            }
            sb.append(v);
            i++;
        }
        if (add == 1) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }

    /**
     * 43. 字符串相乘<br>
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     */
    public String multiply(String num1, String num2) {
        // 暴力
        int len = num1.length();
        int len2 = num2.length();
        if (len < len2)
            return multiply(num2, num1);
        String res = "";
        int i = 0;
        int w = 0;
        int add = 0;
        StringBuilder sb = null;
        while (i < len2) {
            int c = i < len2 ? num2.charAt(len2 - 1 - i) - 48 : 0;
            sb = new StringBuilder();
            for (int j = 0; j < w; j++) {
                sb.append(0);
            }
            int j = 0;
            while (1 < len) {
                int c2 = j < len ? num1.charAt(len - 1 - j) - 48 : 0;
                int v = c * c2 + add;
                sb.append(v % 10);
                add = v / 10;
            }
            if (add >= 1) {
                sb.append(add);
            }
            res = addStrings(sb.reverse().toString(), res);
        }
        // y优化
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        for (i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (result[i + j + 1] + n1 * n2);
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder results = new StringBuilder();
        for (i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0)
                continue;
            results.append(result[i]);
        }
        res = results.toString();
        return res;
    }

    /**
     * 66. 加一<br>
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。<br>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。<br>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        int add = 1;
        while (i >= 0 && add == 1) {
            int v = digits[i] + add;
            add = v / 10;
            digits[i] = v % 10;
            i--;
        }
        if (add == 1) {
            digits = new int[len + 1];
            digits[0] = 1;
        }
        return digits;
    }

    /**
     * 989. 数组形式的整数加法 <br>
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。<br>
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        int i = A.length - 1;
        List<Integer> res = new Vector<Integer>();
        while (i >= 0 || K > 0) {
            int v = A[i] + K;
            K = v / 10;
            res.add(v % 10);
            i--;
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 76. 最小覆盖子串 <br>
     * 给你一个字符串 S、一个字符串 T 。<br>
     * 请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // 哈希 : 错误想法,字符多次出现则搞不定
        // Map<K, V>
        // for (int i = 0; i < t.length(); i++) {
        // }
        return "";
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        /**
         * 直接返回sum == root.val不用判断<br>
         * if (root.left == null && root.right == null && sum == root.val) { <br>
         * return true; }
         */
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        int t = sum - root.val;
        /**
         * 可能存在负数sum<br>
         * if (t < 0) { return false; }
         */
        return hasPathSum(root.left, t) || hasPathSum(root.right, t);
    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // TODO
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] > 0) {
                    continue;
                }
                if (i + 1 < n && obstacleGrid[i + 1][j] == 0) {
                    res += 1;
                }
                if (j + 1 < m && obstacleGrid[i][j + 1] == 0) {
                    res += 1;
                }
            }
        }
        return res;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    public int maxSubArray(int[] nums) {
        /**
         * 暴力 n <sub> 2 </sub>
         */
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmax = nums[i];
            int res = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                res += nums[j];
                tmax = Math.max(tmax, res);
            }
            max = Math.max(max, tmax);
        }
        /**
         * 双指针n
         */
        int l = 0, r = l + 1;
        int len = nums.length;
        int tmax = nums[l];
        int res = nums[l];
        while (r < len) {
        }
        return max;
    }

    /**
     * 120. 三角形最小路径和<br>
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。<br>
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> j = triangle.get(i);
            int n2 = j.size();
            for (int j2 = n2 - 1; j2 >= 0; j2--) {
                if (j2 > 0) {
                    if (j2 == n2 - 1)
                        dp[j2] = j.get(j2) + dp[j2 - 1];
                    else
                        dp[j2] = j.get(j2) + Math.min(dp[j2], dp[j2 - 1]);
                } else {
                    dp[j2] += j.get(j2);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    /**
     * 349.两个数组的交集 <br>
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int integer : nums1) {
            set.add(integer);
        }
        int count = 0;
        for (int i : nums2) {
            if (set.contains(i)) {
                nums2[count++] = i;
                set.remove(i);
            }
        }
        return Arrays.copyOfRange(nums2, 0, count);
    }

    /**
     * 350.两个数组的交集 II <br>
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int count = 0;
        int i1 = 0, i2 = 0;
        while (i1 < l1 || i2 < l2) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] == nums2[i2]) {
                nums1[count] = nums1[i1];
                count++;
            } else {
                i2++;
            }
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = nums1[i];
        }
        // 哈希计数算法
        // 确保参数1是小数组
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        // return Arrays.copyOfRange(intersection, 0, index);
        return res;
    }

    /**
     * 96. 不同的二叉搜索树<br>
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     */
    public int numTrees(int n) {
        /**
         * 方法二：数学 思路与算法
         *
         * 事实上我们在方法一中推导出的 G ( n ) G(n)函数的值在数学上被称为卡塔兰数 C n C n ​ 。卡塔兰数更便于计算的定义如下:
         *
         * C[n + 1] = 2(2n + 1)/(n + 2) * C[n];
         */
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    /**
     * 95. 不同的二叉搜索树II<br>
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树？
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1)
            return new ArrayList<>();
        return doGenerateTrees(1, n);
    }

    private Vector<TreeNode> doGenerateTrees(int s, int n) {
        Vector<TreeNode> nodes = new Stack<TreeNode>();
        if (s > n) {
            return nodes;
        }
        // 枚举可行根节点
        for (int i = s; i <= n; i++) {
            // 获得所有可行的左子树集合
            Vector<TreeNode> left = doGenerateTrees(s, i - 1);
            // 获得所有可行的右子树集合
            Vector<TreeNode> right = doGenerateTrees(i + 1, s);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode lNode : left) {
                for (TreeNode rNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }

    /**
     * 97. 交错字符串<br>
     * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        // return f[n][m];
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1 + len2) {
            return false;
        }
        int i = 0;
        int l = 0;
        int lt = 0;
        int r = 0;
        int rt = 0;
        while (i < len3 && l < len1 && r < len2) {
            char c3 = s3.charAt(i);
            char c1 = s1.charAt(l + lt);
            char c2 = s2.charAt(r + rt);
            if (c3 == c1 && c3 != c2) {
                l++;
                l += lt;
                lt = 0;
                rt = 0;
            } else if (c3 == c2 && c3 != c1) {
                r++;
                r += rt;
                rt = 0;
                lt = 0;
            } else if (c3 == c2 && c3 == c1) {
                lt++;
                rt++;
            } else {
                return false;
            }
            i++;
        }
        if (l == len1) {
            r += rt;
            while (r < len2) {
                if (s3.charAt(i++) != s2.charAt(r++))
                    return false;
            }
        }
        System.out.println(new Date().getTime());
        if (r == len2) {
            l += lt;
            while (l < len1) {
                if (s3.charAt(i++) != s1.charAt(l++))
                    return false;
            }
        }
        return true;
    }

    /**
     * 剑指 Offer 11./154 旋转数组的最小数字<br>
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。<br>
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     */
    public int minArray(int[] numbers) {
        int res = numbers[0];
        for (int i : numbers) {
            if (i < res) {
                return i;
            }
        }
        for (int i : numbers) {
            res = Math.min(i, res);
        }
        // return res;
        int i = 1, j = numbers.length - 2;
        for (; i <= j; i++, j--) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            } else if (numbers[j] > numbers[j + 1]) {
                return numbers[j + 1];
            }
        }
        return Math.min(numbers[i], numbers[j]);
    }

    /**
     * 697. 数组的度<br>
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。<br>
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
                right.put(nums[i], i + 1);
            } else {
                count.put(nums[i], 1);
                left.put(nums[i], i);
            }
        }
        int degree = Collections.max(count.values());
        if (degree == 1) {
            return 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i : count.keySet()) {
            if (count.get(i) == degree)
                res = Math.min(right.get(i) - left.get(i), res);
        }
        return res;
    }

    /**
     * 392. 判断子序列<br>
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。<br>
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。<br>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。<br>
     */
    public boolean isSubsequence(String s, String t) {
        // 双指针
        int len = s.length();
        int end = t.length();
        int k = 0;
        int l = 0;
        while (k < len) {
            if (s.charAt(k) == t.charAt(l)) {
                k++;
                l++;
            } else {
                l++;
            }
            if (l == end && k != len) {
                return false;
            }
        }
        // dp
        int n = s.length(), m = t.length();
        // 初始化储存队列
        int[][] f = new int[m + 1][26];
        // 最后一列赋值
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }
        // 倒序
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    // 储存当前字符位置
                    f[i][j] = i;
                else
                    // 记录当前字符 下一个字符位置
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            // 如果当前字符不存在t中(标记在最后一列)
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            // t中下一个字符的标记
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    /**
     * 718. 最长重复子数组<br>
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     */
    public int findLength(int[] A, int[] B) {
        if (A.length > B.length) {
            return findLength(B, A);
        }
        int res = 0;
        //暴力
        for (int i = 0; i < A.length; i++) {
            if (i >= A.length - res) break;//剪枝
            for (int j = 0; j < B.length; j++) {
                if (j >= B.length - res) break;//剪枝
                if (A[i] == B[j]) {
                    int s = 1;
                    while (i + s < A.length && j + s < B.length && A[i + s] == B[j + s]) s++;
                    res = Math.max(res, s);
                }
            }
        }
        return res;
    }

    /**
     * 133. 克隆图
     * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
     * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
     */
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Integer, Node> visited = new HashMap<>();
        Node to = cloneGraph(node, visited);
        return to;
    }

    private Node cloneGraph(Node node, Map<Integer, Node> visited) {
        Node v = visited.get(node.val);
        if (v == null) {
            v = new Node(node.val);
            visited.put(node.val, v);
        }
        if (node.neighbors == null) {
            return v;
        }
        List<Node> ns = new ArrayList<>();
        for (Node n : node.neighbors) {
            Node nv = visited.get(n.val);
            if (nv == null) ns.add(cloneGraph(n, visited));
            else ns.add(nv);
        }
        v.neighbors = ns;
        return v;
    }

    /**
     * 329. 矩阵中的最长递增路径
     * 给定一个整数矩阵，找出最长递增路径的长度。
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int len = matrix.length, len2 = matrix[0].length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len2; j++) {
                res = Math.max(res, longestIncreasingPath(matrix, i, j));
            }
        }
        return res;
    }

    private int longestIncreasingPath(int[][] matrix, int x, int y) {
        if (x > 0 && matrix[x - 1][y] < matrix[x][y] ||
                (y > 0 && matrix[x][y - 1] < matrix[x][y]) ||
                (x < matrix.length - 1 && matrix[x + 1][y] < matrix[x][y]) ||
                (y < matrix[0].length - 1 && matrix[x][y + 1] < matrix[x][y])) return 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        return longestIncreasingPath(matrix, visited, x, y, 1);
    }

    private int longestIncreasingPath(int[][] matrix, int[][] visited, int x, int y, int count) {
        int res = count;
        visited[x][y] = count;
        if (x > 0 && matrix[x - 1][y] > matrix[x][y] && visited[x - 1][y] < visited[x][y])
            res = Math.max(res, longestIncreasingPath(matrix, visited, x - 1, y, count + 1));
        if (y > 0 && matrix[x][y - 1] > matrix[x][y] && visited[x][y - 1] < visited[x][y])
            res = Math.max(res, longestIncreasingPath(matrix, visited, x, y - 1, count + 1));
        if (x < matrix.length - 1 && matrix[x + 1][y] > matrix[x][y] && visited[x + 1][y] < visited[x][y])
            res = Math.max(res, longestIncreasingPath(matrix, visited, x + 1, y, count + 1));
        if (y < matrix[0].length - 1 && matrix[x][y + 1] > matrix[x][y] && visited[x][y + 1] < visited[x][y])
            res = Math.max(res, longestIncreasingPath(matrix, visited, x, y + 1, count + 1));
        return res;
    }

    /**
     * 315. 计算右侧小于当前元素的个数
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     */
    public List<Integer> countSmaller(int[] nums) {
        PriorityQueue<Integer> r = new PriorityQueue<Integer>();
        //TODO
        // for (int i = nums.length - 1; i >= 0; i--) {
        // int count = 0;
        // for (int j = i + 1; j < nums.length; j++) {
        // if (nums[j] < nums[i]) {
        // count++;
        // }
        // }
        // nums[i] = count;
        // }
        // 超时暴力
        List<Integer> res = new Stack<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] < nums[i]) {
//                    count++;
//                }
//            }
//            res.add(count);
//        }
        int[] re = new int[nums.length];
        re[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
//            int j=i+1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    re[i] = re[j] + 1;
                    break;
                }
            }
        }
//Collections.EMPTY_LIST
        return res;
    }


    /**
     * 104. 二叉树的最大深度<br>
     * 给定一个二叉树，找出其最大深度。<br>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     */
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode root, int dep) {
        if (root == null)
            return dep - 1;
        if (root.left == null && root.right == null)
            return dep;
        return Math.max(maxDepth(root.left, dep + 1), maxDepth(root.right, dep + 1));
    }

    /**
     * 面试题 08.03. 魔术索引 <br>
     * 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。<br>
     * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。<br>
     * 若有多个魔术索引，返回索引值最小的一个。
     */
    public int findMagicIndex(int[] nums) {
        // 二分
        int s = 0, l = nums.length - 1;
        int mid = -1;
        while (s < l) {
            mid = (l - s) / 2 + s;
            if (nums[mid] < mid) {
                l = mid - 1;
            } else if (nums[mid] > mid) {
                s = mid + 1;
            } else {
                while (nums[mid] == mid)
                    mid--;
                return mid + 1;
            }
        }
        // 跳跃循环
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                return i;
            } else if (i < nums[i]) {
                i = nums[i];
            } else {
                i++;
            }
        }
        // 暴力
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return res;
    }

    /**
     * 198. 打家劫舍<br>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[len];
    }

    /**
     * 213. 打家劫舍<br>
     * 给定一个代表每个房屋存放金额的非负整数数组(首尾视为相连)，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        else if (len == 1)
            return nums[0];
        int[] dp = new int[len + 1];
        int[] v1 = new int[len + 1];
        dp[1] = nums[0];
        v1[2] = nums[1];
        for (int i = 1; i < len; i++) {
            if (i != len - 1) {
                dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            } else {
                dp[i + 1] = dp[i];
            }
            v1[i + 1] = Math.max(v1[i], v1[i - 1] + nums[i]);
        }
        return Math.max(v1[len], dp[len]);
    }

    /**
     * 337. 打家劫舍 III <br>
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。“这个地方的所有房屋的排列类似于一棵二叉树”。<br>
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。<br>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额
     */
    public int rob3(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        // 暴力 900ms
        /**
         * <pre>
         * if (root == null) {
         * 	return 0;
         * }
         * int val = root.val;
         * if (root.left != null)
         * 	val += rob3(root.left.left) + rob3(root.left.right);
         * if (root.right != null)
         * 	val += rob3(root.right.left) + rob3(root.right.right);
         * int result = Math.max(rob3(root.left) + rob3(root.right), val);
         * </pre>
         */
        // 暴力 + 记忆化 3ms
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root))
            return memo.get(root);
        int val = root.val;
        if (root.left != null)
            val += rob3(root.left.left) + rob3(root.left.right);
        if (root.right != null)
            val += rob3(root.right.left) + rob3(root.right.right);
        int result = Math.max(rob3(root.left) + rob3(root.right), val);
        memo.put(root, result);
        int[] res = dfs337(root);
        result = Math.max(res[0], res[1]);
        return result;
    }

    private int[] dfs337(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs337(root.left);
        int[] right = dfs337(root.right);
        return new int[]{root.val + left[0] + right[0], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
    }

    class Test {
        int[] nums = null;

        public Test() {
        }

        public Test(int[] nums) {
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            Arrays.sort(nums);
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            return nums;
        }
    }

    class MinStack {
        int[] nums = null;
        int min = 0;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            nums = new int[0];
        }

        public void push(int x) {
            nums = new int[nums.length + 1];
        }

        public void pop() {
            Arrays.copyOf(nums, nums.length - 1);
        }

        public int top() {
            return nums[nums.length - 1];
        }

        public int getMin() {
            return min;
        }
    }
}
