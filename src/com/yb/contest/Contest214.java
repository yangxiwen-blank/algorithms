package com.yb.contest;

import java.util.*;

/**
 * ClassName:    Contest214
 * Description:
 * Datetime:    2020/11/8   10:36
 * Author:   yangbin
 */
public class Contest214 {
    public static void main(String[] args) {
        int[] num = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; ++i) {
            int c = random.nextInt(10000);
            System.out.print(c + ",");
            num[i] = c;
        }
        new Contest214().getMaximumGenerated(100);
        new Contest214().createSortedArray(num);
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] num = new int[n + 1];
        num[0] = 0;
        num[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; ++i) {
            if (i % 2 == 0) num[i] = num[i / 2];
            else num[i] = num[i / 2] + num[i / 2 + 1];

            max = Math.max(max, num[i]);
        }

        return max;
    }

    public int minDeletions(String s) {
        int[] num = new int[26];
        for (char c : s.toCharArray()) {
            ++num[c - 'a'];
        }
        Arrays.sort(num);
        // int len = num.length
        int res = 0;
        for (int i = 24; i >= 0; --i) {
            while (num[i] > 0 && num[i] >= num[i + 1]) {
                res += 1;
                --num[i];
            }
        }
        return res;
    }

    public int maxProfit(int[] inventory, int orders) {
        int M = 1000000007;
        int res = 0;
        int max = 0;
        int count = 0;
        for (int i : inventory) {
            max = (max + i * (i + 1) / 2) % M;
            count += i;
        }

        int d = count - orders;
        // if (d <= len) return max - d;
        // while (d > 0) {
        //
        // }
        int len = inventory.length;
        Arrays.sort(inventory);
        int discount = 0;
        for (int i = 0; i < len; ++i) {
            if (i == 0) discount = inventory[i] * len;
            else discount = (inventory[i] - inventory[i - 1]) * (len - i);
            if (d <= discount) {
                max += inventory[i - 1] * (inventory[i - 1] + 1) / 2 * (len - i);

                break;
            } else {
                d -= (inventory[i] - discount) * (len - i);
                max -= inventory[i] * (inventory[i] + 1) / 2 * (len - i);
                max += inventory[i - 1] * (inventory[i - 1] + 1) / 2 * (len - i);
            }
            discount = inventory[i];
        }
        return res;
    }

    public int createSortedArray(int[] instructions) {
        int res = 0;
        int M = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : instructions) {
            int min = 0, max = 0;
            for (int m : map.keySet()) {
                if (m < i) min += map.get(m);
                else if (m > i) max += map.get(m);
            }
            res = (res + Math.min(max, min)) % M;
            int c = map.getOrDefault(i, 0);
            map.put(i, c + 1);
        }

        return res;
    }
}
