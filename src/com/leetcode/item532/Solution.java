package com.leetcode.item532;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数k，你需要在数组里找到 不同的k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * 这里将k-diff数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 示例 1：
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 *
 * 示例 2：
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 *
 * 示例 3：
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1)。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */

public class Solution {

    public static void main(String[] args) {
        int[] nums={3, 1, 4, 1, 5};
        int k=2;
        System.out.println(findPairs(nums,k));
    }

    public static int findPairs(int[] nums, int k) {
        if(nums.length<2){
            return 0;
        }
        Set<Integer> resultNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    resultNums.add(nums[i] + nums[j]);
                }
            }
        }
        return resultNums.size();
    }

}
