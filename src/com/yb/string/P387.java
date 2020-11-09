package com.yb.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P387 {

    public int firstUniqChar(String s) {
        int res = -1;
        char[] cs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, len = cs.length; i < len; ++i) {
            if (map.containsKey(cs[i])) set.remove(cs[i]);
            else {
                set.add(cs[i]);
                map.put(cs[i], i);
            }
        }

        if (set.size() == 0) return -1;
        res = cs.length;
        for (char c : set) {
            res = Math.min(res, map.get(c));
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        boolean res = true;
        int[] si = new int[26];
        int[] ti = new int[26];
        for (char c : s.toCharArray()) {
            ++si[c - 'a'];
        }
        for (char c : t.toCharArray()) {
            ++ti[c - 'a'];
        }

        for (int i = 0; i < 26; ++i) {
            res &= si[i] == ti[i];
        }
        return res;
    }
}
