package com.yb.list;

import com.yb.ListNode;
import com.yb.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P109 {
    ListNode globalHead;

    /**
     * 109. 有序链表转换二叉搜索树
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        // 中值分治
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        return sortedListToBST(list, 0, list.size() - 1);

        // 中序遍历
        globalHead = head;
        int c = 0;
        while (head != null) {
            ++c;
            head = head.next;
        }
        return buildTree(0, c);
        //快慢指针分治
//        return sortedListToBST(head, null);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    private TreeNode sortedListToBST(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode pre = new TreeNode(mid.val);
        pre.left = sortedListToBST(left, mid);
        pre.right = sortedListToBST(mid.next, right);
        return pre;
    }

    /**
     * 快慢双指针找中值
     */
    private ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private TreeNode sortedListToBST(List<Integer> head, int left, int right) {
        if (left > right) return null;
        int mid = (right + left + 1) / 2;
        TreeNode pre = new TreeNode(head.get(mid));
        pre.left = sortedListToBST(head, left, mid - 1);
        pre.right = sortedListToBST(head, mid + 1, right);
        return pre;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
//        if (slow == null) return false;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) return true;
        }
        return false;
    }

    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     */
    public boolean isPalindrome(ListNode head) {
        //StringBuilder 负数有问题
        //StringBuilder sb = new StringBuilder();
        //StringBuilder reverse = new StringBuilder();
        //int count = 0;
        //
        //while (head != null) {
        //    sb.append(head.val);
        //    reverse.append(head.val);
        //    head = head.next;
        //    ++count;
        //}
        //reverse.reverse();
        //
        //for (int i = 0; i < count/2; ++i) {
        //    if (sb.charAt(i)!= reverse.charAt(i))return false;
        //}

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int s = 0, e = list.size() - 1;
        while (s < e) {
            if (list.get(s).intValue() != list.get(e).intValue()) return false;
            ++s;
            --e;
        }
        return true;
    }
}
