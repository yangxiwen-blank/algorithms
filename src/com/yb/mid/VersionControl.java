package com.yb.mid;

public class VersionControl {
    boolean isBadVersion(int version) {
        if (version < 1702766719) return false;
        else return true;
    }
}
