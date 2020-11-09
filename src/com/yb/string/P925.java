package com.yb.string;

public class P925 {
    public static void main(String[] args) {
        new P925().isLongPressedName("laiden", "laiden");
    }

    public boolean isLongPressedName(String name, String typed) {
        // if (typed.length()>name.length())return true;
        // return false;
        int n = 0, t = 0;
        while (n < name.length() || t < typed.length()) {
            if (n < name.length() && t < typed.length() && name.charAt(n) != typed.charAt(t)) return false;
            int nc = 0, tc = 0;
            while (n + 1 < name.length() && name.charAt(n + 1) == name.charAt(n)) {
                ++nc;
                ++n;
            }
            while (t + 1 < typed.length() && typed.charAt(t + 1) == typed.charAt(t)) {
                ++tc;
                ++t;
            }
            if (tc < nc) return false;
            ++n;
            ++t;
        }
        return true;
    }
}
