package com.yb.dfs;

public class P116 {
    Node prev = null;

    public Node connect(Node root) {
        // bfs
        //if (root == null) return root;
        //Queue<Node> queue = new ArrayDeque<>();
        //queue.offer(root);
        //while (!queue.isEmpty()) {
        //    Node next = null;
        //    for (int i = 0, len = queue.size(); i < len; ++i) {
        //        Node cur = queue.poll();
        //        cur.next = next;
        //        next = cur;
        //        if (cur.right != null) queue.offer(cur.right);
        //        if (cur.left != null) queue.offer(cur.left);
        //    }
        //}
        //return root;
        if (root == null) return root;
        Node tmp = root;
        while (tmp != null) {
            Node head = tmp;
            while (head != null) {
                if (head.next != null)
                    head.right.next = head.next.left;
                head.left.next = root.right;
                head = head.next;
            }
            tmp = tmp.left;
        }
        //dfs
        dfs(root, 0);
        return root;
    }

    private void dfs(Node root, int i) {
        if (root == null) return;
        root.next = prev;
        prev = root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
