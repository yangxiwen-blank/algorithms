package com.yb.dfs;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    List<List<Integer>> pre = new ArrayList<List<Integer>>();
    int[] visited;
    boolean valid = true;
    List<Integer> order210 = new ArrayList<Integer>();
    /**
     * 207. 课程表<br>
     * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。<br>
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]<br>
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            pre.add(new ArrayList<Integer>());
        }
        for (int[] c : prerequisites) {
            pre.get(c[1]).add(c[0]);
        }

        visited = new int[numCourses];
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs207(i);
            }
        }

        return valid;
    }

    /**
     * 210. 课程表 II<br>
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。<br>
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]<br>
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            pre.add(new ArrayList<Integer>());
        }
        for (int[] c : prerequisites) {
            pre.get(c[1]).add(c[0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs207(i);
            }
        }
        if (!valid)
            return new int[]{};

        int i = numCourses - 1;
        for (int o : order210) {
            visited[i--] = o;
        }

        return visited;
    }

    private void dfs207(int i) {
        visited[i] = 1;
        for (int il : pre.get(i)) {
            if (visited[il] == 0) {
                dfs207(il);
                if (!valid) {
                    return;
                }
            } else if (visited[il] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        order210.add(i);
    }
}
