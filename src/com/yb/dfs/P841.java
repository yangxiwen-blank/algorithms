package com.yb.dfs;

import java.util.List;

public class P841 {
    /**
     * 841. 钥匙和房间
     * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。
     * 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
     * 最初，除 0 号房间外的其余所有房间都被锁住。
     * 你可以自由地在房间之间来回走动。
     * 如果能进入每个房间返回 true，否则返回 false。
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        int[] visited = new int[len];
        dfs841(rooms, visited, 0);

        for (int i : visited) {
            if (i == 0) return false;
        }
        return true;
    }

    private void dfs841(List<List<Integer>> rooms, int[] visited, int i) {
        if (visited[i] == 1) {
            return;
        }
        visited[i] = 1;
        List<Integer> keys = rooms.get(i);
        for (int key : keys) {
            dfs841(rooms, visited, key);
        }
    }
}
