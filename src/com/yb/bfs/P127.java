package com.yb.bfs;

import java.util.*;

public class P127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int res = 1;
        int len = wordList.size();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String cur = queue.poll();
                System.out.println(res + "  :  " + cur);
                if (cur.equals(endWord)) return res;

                char[] chars = cur.toCharArray();
                for (int j = 0; j < len; ++j) {
                    String tmp = wordList.get(j);
                    if (diffChar(chars, tmp.toCharArray()) && visited.add(tmp)) queue.offer(tmp);
                }
            }

            ++res;
        }

        return 0;
    }

    private boolean diffChar(char[] cur, char[] tmp) {
        boolean res = false;
        for (int i = 0, len = cur.length; i < len; ++i) {
            if (cur[i] != tmp[i]) {
                if (res) return false;
                res = true;
            }
        }
        return true;
    }

    private Map<String, Set<String>> diffMap(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = -1, len = wordList.size(); i < len; ++i) {
            String si = i < 0 ? beginWord : wordList.get(i);

            for (int j = i + 1; j < len; ++j) {
                String sj = wordList.get(j);
                if (diffChar(si, sj) == 1) {
                    Set<String> iList = map.getOrDefault(si, new HashSet<>());
                    iList.add(sj);
                    map.put(si, iList);

                    Set<String> jList = map.getOrDefault(sj, new HashSet<>());
                    jList.add(si);
                    map.put(sj, jList);
                }
            }
        }
        return map;
    }

    private int diffChar(String cur, String tmp) {
        int res = 0;
        for (int i = 0, len = cur.length(); i < len; ++i) {
            if (cur.charAt(i) != tmp.charAt(i)) ++res;
            if (res > 1) return res;
        }
        return res;
    }

    private int diffCharNum(String cur, String tmp) {
        int res = 0;
        for (int i = 0, len = cur.length(); i < len; ++i) {
            if (cur.charAt(i) != tmp.charAt(i)) ++res;
        }
        return res;
    }

    private int diffCharPos(String cur, String tmp) {
        int res = 0;
        for (int i = 0, len = cur.length(); i < len; ++i) {
            if (cur.charAt(i) != tmp.charAt(i)) {
                res = i;
            }
        }
        return res;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) return res;

        Map<String, Set<String>> diffMap = diffMap(beginWord, endWord, wordList);
        Set<String> visited = new HashSet<>();
        dfs(beginWord, diffMap, new ArrayList<String>(), visited, res, endWord);

//        List<String> begin = new ArrayList<>();
//        begin.add(beginWord);
//
//        Queue<List<String>> queue = new ArrayDeque<>();
//        queue.offer(begin);
//
//        int min = wordList.size() + 1;
//        Set<String> diffList = null;
//        Set<String> visited = new HashSet<>();
//        while (!queue.isEmpty()) {
//            List<String> curList = queue.poll();
//            int size = curList.size();
//            String cur = curList.get(size - 1);
//            if (size > min) continue;
//
//            if (cur.equals(endWord)) {
//                min = Math.min(min, size);
//                res.add(curList);
//            }
//
//            diffList = diffMap.get(cur);
//            if (diffList == null) continue;
//            for (String diff : diffList) {
//                if (!visited.add(diff)) continue;
//                List<String> list = new ArrayList<>(curList);
//
//                list.add(diff);
//                queue.offer(list);
//            }
//        }

        return res;
    }

    private void dfs(String cur, Map<String, Set<String>> diffMap, List<String> curList,
                     Set<String> visited, List<List<String>> res, String endWord) {
        if (!visited.add(cur)) return;

        if (cur.equals(endWord)) {
            res.add(curList);
        }
        Set<String> diffList = diffMap.get(cur);

        List<String> list = new ArrayList<>(curList);
        list.add(cur);
        for (String diff : diffList) {
            dfs(diff, diffMap, list, visited, res, endWord);
            visited.remove(diff);
        }
    }
}
