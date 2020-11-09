package com.yb.list;

import com.yb.ListNode;

import java.util.Stack;

public class P143 {
    public static void main(String[] args) {
        new P143().reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    /**
     * 143. 重排链表
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode prev = new ListNode();
        prev.next = head;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        head = prev.next;
        ListNode tmp = null;
        while (true) {
            if (tmp != null) tmp.next = head;
            tmp = stack.pop();
            if (head == tmp || head.next == tmp) {
                if (head == tmp) head.next = null;
                else tmp.next = null;
                break;
            }
            ListNode next = head.next;
            head.next = tmp;
            head = next;
        }
        head = prev.next;

        ListNode slow = head, fast = head, src = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverseList(slow);
        while (slow != null) {
            ListNode node = src.next;
            ListNode node2 = slow.next;
            src.next = slow;
            src = slow.next = node;
            slow = node2;
        }
    }

    /**
     * 反转一个单链表。
     */
    public ListNode reverseList(ListNode head) {
        /**
         * 迭代<br>
         *
         * <pre>
         * ListNode prev = null;
         * ListNode cur = head;
         * while (cur != null) {
         * 	ListNode tmp = cur.next;
         * 	cur.next = prev;
         * 	prev = cur;
         * 	cur = tmp;
         * }
         * return prev;
         * </pre>
         */
        // 递归
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
