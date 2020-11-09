package com.yb.bfs;

import java.util.*;

public class P909 {

    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int n = 0;

    public static void main(String[] args) {
        new P909().minOperationsMaxProfit(new int[]{10, 9, 6}, 5, 6);
    }

    /**
     * 909. 蛇梯棋<br>
     * N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。<br>
     * 例如，一块 6 x 6 大小的棋盘，编号如下：<br>
     * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；<br>
     * 如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。<br>
     * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。<br>
     * 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：<br>
     * 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。<br>
     * 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。<br>
     * 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。 <br>
     * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。<br>
     * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
     */
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        int[] end = n % 2 == 0 ? new int[]{0, 0} : new int[]{0, n - 1};

        int[][] nums = new int[n][n];
        int c = 1;
        for (int i = n - 1; i >= 0; --i) {
            if ((n - 1) % 2 == 1)
                for (int j = 0; j < n; ++j) {
                    nums[i][j] = c++;
                }
            else
                for (int j = n; j >= 0; --j) {
                    nums[i][j] = c++;
                }
        }
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{n - 1, 0});
        visited[n - 1][0] = true;
        int move = 0;
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; ++i) {
                int[] cur = queue.poll();
                if (board[cur[0]][cur[1]] == n * n || (cur[0] == end[0] && cur[1] == end[1])) return move;
                //if (board[cur[0]][cur[1]] == n * n || nums[cur[0]][cur[1]] == n * n) return move;


            }
            move += 1;
        }
        return -1;
    }

    private int[] numToRc(int num) {

        int r = n - (num - 1) / n - 1;
        int c = 0;
        if (n % 2 == 1) {
            c = n - (num - 1) % n - 1;
        } else {
            c = (num - 1) % n;
        }

        return new int[]{r, c};
    }

    private int rcToNum(int[] rc) {

        return 0;
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (runningCost >= boardingCost * 4) return -1;
        int profit = 0;
        int all = 0;
        int cNum = 0;
        int res = 0;
        int max = 0;
//        for (int i = 0, len = customers.length; i < len; ++i) {
        int i = 0;
        while (cNum > 0 || i < customers.length) {
            int customer = i < customers.length ? customers[i] : 0;
            if (cNum + customer >= 4) {
                profit = 4 * boardingCost - runningCost;
                cNum = cNum + customer - 4;
            } else {
                profit = (cNum + customer) * boardingCost - runningCost;
                cNum = 0;
            }
            if (profit > 0 && all > 0) res = i + 1;
            max = Math.max(max, all);
            all += profit;
            ++i;
        }
        return max == 0 ? -1 : res;
    }

    public int maximumRequests(int n, int[][] requests) {
        int res = 0;
        int[] from = new int[n];
        int[] to = new int[n];
        for (int[] request : requests) {
            if (request[0] == request[1]) {
                res += 1;
                continue;
            }
            from[request[0]] += 1;
            to[request[1]] += 1;
        }
        for (int i = 0; i < n; ++i) {
            if (from[i] == 0 || to[i] == 0) continue;
            res += Math.min(from[i], to[i]);
        }
        return res;
    }

    class ThroneInheritance {
        Node inheritanceOrder = null;
        Set<String> dead = new HashSet<>();

        public ThroneInheritance(String kingName) {
            inheritanceOrder = new Node(kingName);
        }

        public void birth(String parentName, String childName) {
            Node tmp = inheritanceOrder;
            bfs(tmp, parentName, childName);
        }

        private void bfs(Node node, String parentName, String childName) {
            if (parentName.equals(node.name)) {
                node.children.add(new Node(childName));
                return;
            }
            for (Node n : node.children) {
                bfs(n, parentName, childName);
            }
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> res = new ArrayList<>();
//            Queue<Node> queue = new ArrayDeque<>();
//            queue.offer(inheritanceOrder);
//            while (!queue.isEmpty()){
//                Node cur = queue.poll();
//                if (!dead.contains(cur.name)) res.add(cur.name);
//                for (Node n : cur.children) {
//                    queue.o
//                }
//            }
            getInheritanceOrder(inheritanceOrder, res);
            return res;
        }

        private void getInheritanceOrder(Node cur, List<String> res) {
            if (!dead.contains(cur.name)) res.add(cur.name);
            for (Node n : cur.children) {
                getInheritanceOrder(n, res);
            }
        }

        class Node {
            String name;
            List<Node> children;

            Node(String name) {
                this.name = name;
                children = new ArrayList<>();
            }

            protected void addChild(String name) {
                children.add(new Node(name));
            }

        }
    }
}
