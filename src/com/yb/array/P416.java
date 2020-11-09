package com.yb.array;

import java.util.*;

public class P416 {
    public static void main(String[] args) {
//        new P416().canPartition(new int[]{1, 2, 3, 6, 4, 2, 1, 2, 5});
//        System.out.println(new P416().maximalNetworkRank(3, new int[][]{{0, 2}, {0, 1}}));
        System.out.println(new P416().commonChars(new String[]{"bella","label","roller"}));
    }

    /**
     * 416. 分割等和子集<br>
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        int left = 0, right = len - 1;
        int lNum = 0, rNum = 0;

        while (left <= right) {
            if (lNum >= rNum) {
                lNum -= rNum;
                rNum = nums[right];
                right -= 1;
            } else {
                rNum -= lNum;
                lNum = nums[left];
                left += 1;
            }
        }

        return lNum == rNum;
    }

    public int maxDepth(String s) {
        int l = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
                res = Math.max(l, res);
            } else if (c == ')') l--;
//            if (l==0 && c==')')
        }
        return res;
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) return 0;
        int[] degree = new int[n];

        int max = 0;
        Map<Integer, Set<Integer>> net = new HashMap<>();
        for (int[] road : roads) {
            degree[road[0]] += 1;
            degree[road[1]] += 1;
            if (!net.containsKey(road[0])) net.put(road[0], new HashSet<>());
            net.get(road[0]).add(road[1]);
            if (!net.containsKey(road[1])) net.put(road[1], new HashSet<>());
            net.get(road[1]).add(road[0]);
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(degree[i])) map.put(degree[i], new HashSet<>());
            map.get(degree[i]).add(i);
        }

        Arrays.sort(degree);
        int res = degree[n - 1] + degree[n - 2];
        Set<Integer> maxes = map.get(degree[n - 1]);
        if (degree[n - 1] != degree[n - 2]) {
            Set<Integer> mines = map.get(degree[n - 2]);
            for (int i : mines) {
                for (int j : maxes) {
                    if (i == j) continue;
                    if (!net.get(i).contains(j)) return res;
                }
            }
        } else {
            for (int i : maxes) {
                for (int j : maxes) {
                    if (i == j) continue;
                    if (!net.get(i).contains(j)) return res;
                }
            }
        }

        return res - 1;
//        if (d)


//        boolean exist = false;
//        for (int[] road : roads) {
//            if ((road[0] == net[0] && road[1] == net[1]) || (road[0] == net[1] && road[1] == net[0])) {
//                exist = true;
//                break;
//            }
//        }
//        return exist ? max + min - 1 : max + min;
    }

    public boolean checkPalindromeFormation(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int al = 0, bl = 0;
        int ar = as.length - 1, br = bs.length - 1;
        while (al < br) {
            if (as[al] == bs[br]) {
                al += 1;
                br -= 1;
            } else break;
        }
        if (al >= br) return true;

        al = 0;
        br = bs.length - 1;
        while (bl < br) {
            if (bs[bl] == bs[br]) {
                bl += 1;
                br -= 1;
            } else break;
        }
        if (bl >= br) return true;

        al = 0;
        ar = as.length - 1;
        while (al < ar) {
            if (as[al] == as[ar]) {
                al += 1;
                ar -= 1;
            } else break;
        }
        if (al >= ar) return true;

        bl = 0;
        ar = as.length - 1;
        while (bl < ar) {
            if (bs[bl] == as[ar]) {
                bl += 1;
                ar -= 1;
            } else break;
        }
        if (bl >= ar) return true;
//        new String('')
        return false;
    }

    public List<String> commonChars(String[] A) {
        int len = A.length;
        int[][] hash = new int[26][len];
        int n = 0;
        int max = 0;
        for (String a : A) {
            for (char c : a.toCharArray()) {
                hash[c - 'a'][n] += 1;
            }
            max=Math.max(max,a.length());
            n += 1;
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            int min = max;
            for (int j = 0; j < len; ++j) {
                min = Math.min(min, hash[i][j]);
            }
            for (int j = 0; j < min; ++j) {
                res.add(new String(new char[]{(char) ('a' + i)}));
            }
        }
        return res;
    }
}
