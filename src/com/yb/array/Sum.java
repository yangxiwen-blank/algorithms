package com.yb.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Sum {
    // 暴力求和
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("i: " + nums[i] + "   j: " + nums[j]);
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // 哈希求和
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey((target - nums[i]))) {
                System.out.println("i: " + nums[i] + "   j: " + (target - nums[i]));
                return new int[]{nums[i], map.get((target - nums[i]))};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 167. 两数之和 II - 输入有序数组<br>
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。<br>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     */
    public int[] twoSum3(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0, r = len - 1;
        while (l < r) {
            if (numbers[r] + numbers[l] > target) {
                r--;
            } else if (numbers[r] + numbers[l] < target) {
                l++;
            } else {
                break;
            }
        }
        return new int[]{l, r};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rvalue = new Vector<List<Integer>>();
        Arrays.sort(nums);
        // int zcount = 0, left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            // 双指针
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] >= 0) {
                // 标准值>0,后续必然无结果,退出
                return rvalue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去除重复标准值
                continue;
            }

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    // 和>0,右指针值过大,右指针移位
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    // 和<0,左指针值过小,左指针移位
                    left++;
                } else {
                    // =0, 找到一对值,双指针移位
                    rvalue.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    System.out.println("i: " + nums[i] + " j: " + nums[left] + " k: " + nums[right]);
                    while (nums[left + 1] == nums[left] && left + 1 < right)// 去除左指针重复值
                        left++;
                    while (nums[right - 1] == nums[right] && left < right - 1)// 去除右指针重复值
                        right--;
                    left++;
                    right--;
                }
            }
        }
        // if (nums[i - 1] < 0 && nums[i] >= 0) {
        // left = i - 1;
        // if (nums[i] > 0) {
        // right = i;
        // } else {
        // left = i;
        // zcount = 1;
        // }
        // } else if (nums[i - 1] == 0 && nums[i] > 0) {
        // //
        // right = i;
        // } else if (nums[i - 1] == 0 && nums[i] == 0) {
        // // 多个0
        // zcount++;
        // }
        // }
        // if (zcount >= 3) {
        // rvalue.add(new Vector<>(Arrays.asList(new Integer[] { 0, 0, 0 })));
        // }
        /**
         * 两层暴力(重复值未解决) <br>
         * HashMap<Integer, Integer> map = null; HashSet<Integer> used = new
         * HashSet<Integer>(); for (int i = 0; i < nums.length; i++) { if
         * (!used.contains(nums[i])) { used.add(nums[i]); } else { continue; } int
         * target = 0 - nums[i].intValue(); map = new HashMap<>(); for (int j = i + 1; j
         * < nums.length; j++) { if (map.containsKey(nums[j]) && target - nums[j] !=
         * nums[j]) { continue; } if (map.containsKey(target - nums[j].intValue())) {
         * System.out.println("i: " + nums[i] + " j: " + (target - nums[j]) + " k: " +
         * nums[j]); // return new int[] { nums[i], map.get((target - nums[i])) };
         * rvalue.add(new Vector<>(Arrays.asList(new Integer[] { nums[i], target -
         * nums[j], nums[j] }))); used.add(nums[j]); used.add(0 - nums[i] - nums[j]); }
         * map.put(nums[j].intValue(), j); } }
         */
        return rvalue;
    }

    /**
     * 16. 最接近的三数之和 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与
     * target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。<br>
     * 解法: 双指针游标
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                // 判断最小值
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(result - target) > Math.abs(min - target))
                        result = min;
                    System.out.println("i: " + i + " left: " + left + " right: " + right);
                    break;
                }
                // 判断最大值
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    System.out.println("i: " + i + " left: " + left + " right: " + right);
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    System.out.println("i: " + i + " left: " + left + " right: " + right + " sum: " + sum);
                    result = sum;
                }
                if (sum > target) {
                    right--;
                    while (left != right && nums[right] == nums[right + 1])
                        right--;
                } else {
                    left++;
                    while (left != right && nums[left] == nums[left - 1])
                        left++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rvalue = new Vector<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target / 4) {
                // 标准值>0,后续必然无结果,退出
                return rvalue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去除重复标准值
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 双指针
                int left = j + 1;
                int right = nums.length - 1;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    // 去除重复标准值
                    continue;
                }
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        // 和>0,右指针值过大,右指针移位
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        // 和<0,左指针值过小,左指针移位
                        left++;
                    } else {
                        // =0, 找到一对值,双指针移位
                        rvalue.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[left], nums[right]}));
                        while (nums[left + 1] == nums[left] && left + 1 < right)// 去除左指针重复值
                            left++;
                        while (nums[right - 1] == nums[right] && left < right - 1)// 去除右指针重复值
                            right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return rvalue;
    }

    /**
     * 16. 最接近的三数之和 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与
     * target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。<br>
     * 解法: 双指针中位值(存在跳值错误)
     */
    public int threeSumClosest2(int[] nums, int target) {

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right - 1) {
                // 判断最小值
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(result - target) > Math.abs(min - target))
                        result = min;
                    break;
                }
                // 判断最大值
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    break;
                }
                // 双指针循环
                System.out.println("i: " + i + " left: " + left + " right: " + right);
                int sign = (left + right) / 2;
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    right = sign;
                } else {
                    left = sign;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 限制： 1
     * <= n <= 10000 能用的只有加减法，赋值，位运算符以及逻辑运算符。
     */
    public int sumNums(int n) {
        /***
         * 方法一: <br>
         * 递归代替循环, <br>
         * 逻辑运算符 && 短路代替if(左侧不成立右侧不执行) <br>
         * boolean f = n > 0 && (n += sumNums(n - 1)) > 0;
         */

        /***
         * 方法二: <br>
         * 由 等差数列求和公式 (a1+an)* n /2 可知 1+2+...+n 等价于 (1+n)n/2, <br>
         * 对于除以 2 我们可以用右移操作符来模拟，那么等式变成了 n(n+1)>>1; <br>
         * 也等于n<sup>2</sup> +n >> 1 <br>
         * return (int) (Math.pow(n, 2) + n) >> 1; <br>
         * 考虑 A 和 B 两数相乘的时候我们如何利用加法和位运算来模拟，其实就是将 B 二进制展开，如果 B 的二进制表示下第 i 位为
         * 1，那么这一位对最后结果的贡献就是 A*(1<<i) ，即 A<<i。我们遍历 B
         * 二进制展开下的每一位，将所有贡献累加起来就是最后的答案，这个方法也被称作「俄罗斯农民乘法」.<br>
         * 这个方法经常被用于两数相乘取模的场景，如果两数相乘已经超过数据范围，但取模后不会超过，我们就可以利用这个方法来拆位取模计算贡献，保证每次运算都在数据范围内。
         * 下面给出这个算法的 C++ 实现：
         *
         * <pre>
         * int quickMulti(int A, int B) {
         * 	int ans = 0;
         * 	for (; B; B >>= 1) {
         * 		if ((B & 1) > 0) {
         * 			ans += A;
         *        }
         * 		A <<= 1;
         *    }
         * 	return ans;
         * }
         *
         * int quickMulti(int A, int B) {
         * 	int ans = 0;
         * 	for (; B; B >>= 1) {
         * 		if (B & 1) {
         * 			ans += A;
         *        }
         * 		A <<= 1;
         *    }
         * 	return ans;
         * }
         * </pre>
         *
         * 可以看到上面的 C++ 实现里我们还是需要循环语句，有没有办法去掉这个循环语句呢？答案是有的，那就是自己手动展开，因为题目数据范围 n 为
         * [1,10000]，所以 n 二进制展开最多不会超过 14 位，我们手动展开 14 层代替循环即可，至此满足了题目的要求，具体实现可以参考下面给出的代码。
         *
         */

        int ans = 0, A = n, B = n + 1;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        System.out.println(ans >> 1);
        return ans;
    }
}
