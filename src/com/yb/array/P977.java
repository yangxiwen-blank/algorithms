package com.yb.array;

public class P977 {
    public int[] sortedSquares(int[] A) {
        int left = 0, len = A.length, right = 0;
        int[] res = new int[len];
        if (A[0] >= 0) {
            for (int i = 0; i < len; ++i) {
                A[i] *= A[i];
            }
            return A;
        }
        if (A[len - 1] < 0) {
            for (int i = len - 1; i >= 0; --i) {
                res[len - 1 - i] = A[i] * A[i];
            }
            return res;
        }

        for (int i = 1; i < len; ++i) {
            if (A[i - 1] < 0 && A[i] >= 0) {
                left = i - 1;
                right = i;
            }
        }
        int i = 0;
        while (left >= 0 || right < len) {
            if (left < 0) {
                res[i] = A[right] * A[right];
                ++right;
            } else if (right == len) {
                res[i] = A[left] * A[left];
                --left;
            } else if (A[left] * A[left] > A[right] * A[right]) {
                res[i] = A[right] * A[right];
                ++right;
            } else {
                res[i] = A[left] * A[left];
                --left;
            }
            ++i;
        }
        return res;
    }
}
