package com.yb.array;

import java.util.*;

public class Duplicate {
    public static void main(String[] args) {
        System.out.println(new Duplicate().backspaceCompare("ab##", "a#c#"));
    }

    /**
     * 217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
            if (set.size() != i) return true;
        }
        for (int i : nums) {
            if (!set.add(i)) return true;
        }
        return false;
    }

    /**
     * 219. 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }

        return false;
    }

    /**
     * 220. 存在重复元素 III
     * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
     * 如果存在则返回 true，不存在返回 false。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //TODO xxxxx不知道错哪了，慢慢看
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (j - i <= k && Math.abs(nums[j] - nums[i]) <= t) return true;
            }
        }

        return false;
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0, len = s.length(); i < len; ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                res = Math.max(res, i - map.get(c) - 1);
            } else
                map.put(c, i);
        }
        return res;
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int len = scores.length;
        for (int i = 0; i < len; ++i) {
            if (!map.containsKey(ages[i])) map.put(ages[i], new PriorityQueue<>());
            map.get(ages[i]).offer(scores[i]);
        }
        return 0;
    }

    public String findLexSmallestString(String s, int a, int b) {

        int count = 10;
        if (a == 5) count = 2;
        else if (a % 2 == 0) count = 5;

        int len = s.length();
        char[] odd = new char[len / 2];
        char[] even = new char[len / 2];

        for (int i = 0; i < len; ++i) {
            if (i % 2 == 0) odd[i / 2] = s.charAt(i);
            else even[i / 2] = s.charAt(i);
        }


        int[] aa = new int[count];
        aa[0] = a;
        for (int i = 1; i < count; ++i) {
            aa[i] = (aa[i - 1] + a) % 10;
        }

        odd = findSmallestString(odd, a);
        if (b % 2 != 0) {
            even = findSmallestString(even, a);
        }
        return "";
    }

    private char[] findSmallestString(char[] odd, int a) {
        char src = odd[0];
        int len = odd.length;
        char[] res = null;
        int min = 9, sum = len * 9 + 1;
        int pos = -1;
        do {
            int m = 9;
            int n = 0;
            for (int i = 0; i < len; ++i) {
                int tmp = (odd[i] - '0' + a) % 10;
                m = Math.min(m, tmp);
                n += tmp;
                odd[i] = (char) ('0' + tmp);
            }
            if (m < min) {
                min = m;
                sum = n;
                res = Arrays.copyOf(odd, len);
            } else if (m == min && n < sum) {
                min = m;
                sum = n;
                res = Arrays.copyOf(odd, len);
            }

        } while (src != odd[0]);
        return res;
    }

    public boolean backspaceCompare(String S, String T) {
        int sNum = 0, tNum = 0;
        int s = S.length() - 1;
        int t = T.length() - 1;
        while (s >= 0 && t >= 0) {
            while (s >= 0 && (S.charAt(s) == '#' || sNum > 0)) {
                if (S.charAt(s) == '#') ++sNum;
                else --sNum;
                --s;
            }
            while (t >= 0 && (T.charAt(t) == '#' || tNum > 0)) {
                if (T.charAt(t) == '#') ++tNum;
                else --tNum;
                --t;
            }
            if (s >= 0 && t >= 0 && S.charAt(s) != T.charAt(t)) return false;
            --s;
            --t;
        }
        return s == t;
    }
}
