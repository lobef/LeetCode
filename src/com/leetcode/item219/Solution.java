package com.leetcode.item219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
public class Solution {


    public static void main(String[] args) {
//        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
//        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
//        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
//        System.out.println(containsNearbyDuplicate2(new int[]{1, 2, 3, 1}, 3));
//        System.out.println(containsNearbyDuplicate2(new int[]{1, 0, 1, 1}, 1));
//        System.out.println(containsNearbyDuplicate2(new int[]{1,2,3,1,2,3}, 2));
        System.out.println(containsNearbyDuplicate3(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate3(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate3(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    // 方法一我自己写的

    /**
     * 执行用时: 18 ms
     * 内存消耗: 47.5 MB
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> param = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer temp = param.get(nums[i]);
            if (temp != null && Math.abs(temp - i) <= k) {
                return true;
            }
            param.put(nums[i], i);
        }
        return false;
    }
    // 方法二  我自己写的

    /**
     * 执行用时：1597 ms
     * 内存消耗：50.4 MB
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int m = i + 1; m - i <= k && m < nums.length; m++) {
                if (nums[i] == nums[m]) {
                    return true;
                }
            }
        }
        return false;
    }

    //方法三
    // 滑动窗口
    /**
     * 执行用时: 18 ms
     * 内存消耗: 46.5 MB
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate3(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
