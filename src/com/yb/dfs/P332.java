package com.yb.dfs;

import java.util.*;

public class P332 {
    /**
     * 332. 重新安排行程<br>
     * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。<br>
     * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。<br>
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        List<String> res = new LinkedList<>();
        // 逆序
        dfs332("JFK", map, res);
        // 正序代码，难以排除疏漏问题
        //String from = "JFK";
        //res.add(from);
        //String to = "";
        //Queue<String> aa = null;
        //while (ts.size() > 0 && ts.containsKey(from)) {
        //    aa = ts.get(from);
        //    to = aa.poll();
        //    if (aa.peek() == null) {
        //        ts.remove(from);
        //    }
        //    if ((ts.get(to) == null || ts.get(to).peek() == null) && aa.peek() != null) {
        //        String tmp = aa.poll();
        //        aa.offer(to);
        //        from = tmp;
        //    } else
        //        from = to;
        //    if (from != null)
        //        res.add(from);
        //}
        Collections.reverse(res);
        return res;
    }

    private void dfs332(String from, Map<String, Queue<String>> ts, List<String> res) {
        while (ts.containsKey(from) && ts.get(from).peek() != null) {
            from = ts.get(from).poll();
            dfs332(from, ts, res);
        }
        res.add(from);
    }
}
