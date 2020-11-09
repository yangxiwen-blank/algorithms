package com.yb.array;

import java.util.*;

/**
 * ClassName:    Intervals
 * Description:
 * Datetime:    2020/11/4   15:31
 * Author:   yangbin
 */
public class Intervals {
    public static void main(String[] args) {
        // new Intervals().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9, 10});
        // new Intervals().eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {1, 3}, {2, 4}, {3, 5}, {3, 5}, {4, 6}});
        new Intervals().intervalIntersection(new int[][]{{3, 5}, {9, 20}},
                new int[][]{{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}});
        // new Intervals().numSubarrayBoundedMax(new int[]{34, 46, 51, 92, 50, 61, 49, 82, 4, 4}, 18, 84);
    }

    /**
     * 56. 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[count][1] < intervals[i][0]) {
                ++count;
                intervals[count] = intervals[i];
            } else {
                intervals[count][0] = Math.min(intervals[count][0], intervals[i][0]);
                intervals[count][1] = Math.max(intervals[count][i], intervals[i][i]);
            }
        }
        return Arrays.copyOfRange(intervals, 0, count + 1);
    }

    /**
     * 57. 插入区间<br>
     * 给出一个无重叠的 e.g:[[1,3],[6,9]]，按照区间起始端点排序的区间列表。<br>
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠。<br>
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // for (int i = 0; i < len; i++) {
        // if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
        //     tmp[s][0] = intervals[i][0];
        //     tmp[s++][1] = intervals[i][1];
        // } else if (intervals[i][0] < newInterval[0] && intervals[i][1] > newInterval[0]
        //         && intervals[i][1] <= newInterval[1]) {
        //     tmp[s][0] = intervals[i][0];
        //     tmp[s][1] = newInterval[1];
        // } else if (intervals[i][0] < newInterval[0] && intervals[i][1] > newInterval[1]) {
        //     return intervals;
        // } else if (intervals[i][0] > newInterval[0] && intervals[i][1] > newInterval[1]) {
        //     return intervals;
        // }
        // s = i;
        // }
        if (intervals == null || intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        if (newInterval == null) return intervals;
        int len = intervals.length;
        int[][] res = new int[len + 1][2];
        int pos = 0;
        // if (newInterval[1] < intervals[0][0]) res[pos++] = newInterval;
        int i = 0;
        for (; i < len; ++i) {
            int[] interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                res[pos++] = interval;
            } else if (interval[0] > newInterval[0] && interval[1] < newInterval[1]) continue;
            else if (interval[0] > newInterval[1]) break;
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (pos <= len) {
            res[pos++] = newInterval;
            for (; i < len; ++i) {
                res[pos++] = intervals[i];
            }
        }

        return Arrays.copyOfRange(res, 0, pos);
    }

    /**
     * 228. 汇总区间<br>
     * 给定一个无重复元素的有序整数数组 nums 。<br>
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。<br>
     * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，<br>
     * 并且不存在属于某个范围但不属于 nums 的数字 x 。<br>
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：<br>
     * "a->b" ，如果 a != b<br>
     * "a" ，如果 a == b
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int len = nums.length;
        for (; i < len - 1; ++i) {
            int s = nums[i];
            while (i < len - 1 && nums[i + 1] == nums[i] + 1) ++i;
            int e = nums[i];
            if (s == e) res.add("" + s);
            else res.add("" + s + "->" + e);
        }
        if (i == len - 1) res.add("" + nums[i]);
        return res;
    }

    /**
     * [1288]删除被覆盖区间<br>
     * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。<br>
     * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。<br>
     * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int l = 0, r = 1;
        int res = 0, len = intervals.length;
        boolean[] d = new boolean[len];
        while (r < len) {
            if (intervals[l][0] <= intervals[r][0] && intervals[l][1] >= intervals[r][1])
                res += 1;
            else
                l = r;
            ++r;

        }

        return len - res;
    }

    /**
     * 1508. 子数组和排序后的区间和<br>
     * 给你一个数组 nums ，它包含 n 个正整数。<br>
     * 你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n*(n+1)/2 个数字的数组。<br>
     * 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。<br>
     * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
     */
    public int rangeSum(int[] nums, int n, int left, int right) {
        int len = n * (n + 1) / 2;
        int[] res = new int[len];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = i; j < n; ++j) {
                sum += nums[j];
                res[count++] = sum;
            }
        }
        Arrays.sort(res);
        int sum = 0;
        for (int i = left - 1; i < right; ++i) {
            sum += res[i];
            sum %= 1000000007;
        }
        return sum;
    }

    /**
     * 795. 区间子数组个数<br>
     * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。<br>
     * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
     */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length, l = -1, r = -1;
        int res = 0;
        List<Integer> top = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            if (A[i] <= R) {
                if (A[i] >= L) top.add(i);
                r = i;
            } else {
                res += noTopSubarray(top, l, r);
                l = i;
            }
        }
        return res + noTopSubarray(top, l, r);
        // return count(A,R)-count(A,L-1);
    }

    private int count(int[] a, int bound) {
        int cur = 0, res = 0;
        for (int i : a) {
            cur = i <= bound ? cur + 1 : 0;
            res += cur;
        }
        return res;
    }

    private int noTopSubarray(List<Integer> top, int l, int r) {
        int res = 0;
        if (!top.isEmpty()) {
            if (r > l)
                res += (r - l) * (r - l + 1) / 2;
            for (int h : top) {
                res -= (h - 1 - l) * (h - l) / 2;
                l = h;
            }
            res -= (r - l) * (r - l + 1) / 2;
            top.clear();
        }
        return res;
    }

    /**
     * 435. 无重叠区间<br>
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。<br>
     * 注意:
     * 可以认为区间的终点总是大于它的起点。<br>
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] last = intervals[0];
        int res = 0;
        for (int i = 1, len = intervals.length; i < len; ++i) {
            // if (intervals[i][0] < max) break;
            if (intervals[i][0] == last[0]) {
                res += 1;
                last = intervals[i];
            } else {
                if (intervals[i][0] >= last[1]) {
                    last = intervals[i];
                    continue;
                } else {
                    res += 1;
                    last = intervals[i][1] > last[1] ? last : intervals[i];
                    // max = Math.min(max, intervals[i][1]);
                }
            }
        }
        return res;
    }

    /**
     * 436. 寻找右区间<br>
     * 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，<br>
     * 它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。<br>
     * 对于任何区间，你需要存储的满足条件的区间 j 的最小索引，<br>
     * 这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。<br>
     * 如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。<br>
     * 注意:
     * 你可以假设区间的终点总是大于它的起始点。<br>
     * 你可以假定这些区间都不具有相同的起始点。
     */
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[] res = new int[len];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(intervals[i][0])) continue;
            map.put(intervals[i][0], i);
        }
        int[][] bound = new int[map.size()][2];
        int c = 0;
        for (int i : map.keySet()) {
            bound[c][0] = i;
            bound[c++][1] = map.get(i);
        }

        //lambda
        Arrays.sort(bound, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < len; ++i) {
            int[] interval = intervals[i];
            int target = interval[1];
            res[i] = getRightBound(bound, target);
        }
        return res;
    }

    private int getRightBound(int[][] bound, int target) {
        int l = 0, r = bound.length - 1;
        if (bound[l][0] > target || bound[r][0] < target) return -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (bound[mid][0] > target) r = mid;
            else if (bound[mid][0] < target) l = mid + 1;
            else return bound[mid][1];
        }
        return bound[l][1];
    }

    /**
     * 986. 区间列表的交集<br>
     * 给定两个由一些<strong>闭区间</strong>组成的列表，每个区间列表都是成对不相交的，并且已经排序。<br>
     * 返回这两个区间列表的交集。
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        /*List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);*/

        if (A == null || A.length == 0 || B == null || B.length == 0) return new int[0][];
        List<int[]> list = new ArrayList<>();
        int tmp = 0;
        for (int i = 0, len = A.length; i < len; ++i) {
            for (int j = tmp, len2 = B.length; j < len2; ++j) {
                if (B[j][1] < A[i][0]) continue;
                else /*if (B[j][0]> A[i][1])break;*/ {
                    if (B[j][0] > A[i][1]) {
                        tmp = j;
                        break;
                    }
                    if (A[i][0] >= B[j][0])
                        list.add(new int[]{A[i][0], Math.min(B[j][1], A[i][1])});
                    else if (A[i][1] <= B[j][1])
                        list.add(new int[]{Math.max(A[i][0], B[j][0]), A[i][1]});
                    else list.add(B[j]);
                    if (B[j][1] >= A[i][1]) {
                        tmp = j;
                        break;
                    }
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0, len = list.size(); i < len; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 1024. 视频拼接<br>
     * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。<br>
     * 这些片段可能有所重叠，也可能长度不一。<br>
     * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。<br>
     * 我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。<br>
     * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。<br>
     * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。<br>
     */
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int len = clips.length;
//        int res = -1;
        if (clips[0][0] > 0 || clips[len - 1][1] < T - 1) return -1;

//        int end = 0;
        int[] res = new int[len];
        int[] cur = new int[2];
        for (int[] clip : clips) {
//            if (end<clip[1])end
        }
        return 0;
    }


}
