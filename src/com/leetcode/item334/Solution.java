package com.leetcode.item334;

/**
 * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 *
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 *
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * 
 *
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 *
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums));
        nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(nums));
        nums = new int[]{2, 1, 5, 0, 4, 6};
        System.out.println(increasingTriplet(nums));
    }


    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int k = i + 1; k < nums.length - 1; k++) {
//                if (nums[i] < nums[k]) {
//                    for (int m = k + 1; m < nums.length; m++) {
//                        if (nums[k] < nums[m]) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
        int max = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= max) {
                max = num;
            } else {
                return true;
            }
        }

        return false;
    }

}
