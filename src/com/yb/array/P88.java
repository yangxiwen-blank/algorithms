package com.yb.array;

public class P88 {

    public static void main(String[] args) {
//        merge(new int[]{1, 2, 3, 4, 0, 0, 0}, 4, new int[]{2, 5, 6}, 3);
    }

    /**
     * 88.合并两个有序数组<br>
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。<br>
     * 说明:<br>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。<br>
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。<br>
     * 示例: 输入:<br>
     * nums1 = [1,2,3,0,0,0], m = 3<br>
     * nums2 = [2,5,6],       n = 3<br>
     * 输出: [1,2,2,3,5,6]<br>
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= n; --i) {
            nums1[i] = nums1[i - n];
        }

        int x = n, y = 0;
        for (int i = 0; i < m + n; ++i) {
            if (y < n && (x == m + n || nums1[x] > nums2[y])) {
                nums1[i] = nums2[y++];
            } else {
                nums1[i] = nums1[x++];
            }
        }
    }
}
