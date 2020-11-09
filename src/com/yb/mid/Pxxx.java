package com.yb.mid;

public class Pxxx extends VersionControl {
    public int firstBadVersion(int n) {
//        int s = 0;
//        int mid = (s + n) / 2;
//        while (mid < n) {
//            if (!isBadVersion(mid)) {
//                s = mid;
//                mid = (int) (((long) mid + n) / 2);
//            } else {
//                n = mid;
//                mid = (int) (((long) mid + s) / 2);
//            }
//        }
//        return mid;

        int s = 0;
        while (s < n) {
            int mid = s + (n - s) / 2;
            if (isBadVersion(mid)) {
                n = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
