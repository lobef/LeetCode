package com.leetcode.item523;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 *
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 *
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 */
public class SubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

//        第一种方法   测试用例过长时，则出现执行时间过长而不过
//        for (int i = 1; i < nums.length; i++) {
//            int start = 0, end = i;
//            while (end <= nums.length - 1) {
//                long sum = 0;
//                for (int n = start; n <= end; n++) {
//                    sum += nums[n];
//                }
//                if (sum % k == 0) {
//                    return true;
//                }
//                start++;
//                end++;
//            }
//        }
        int m = nums.length;
        if (m < 2)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder=0;
        for (int i=0;i<m;i++) {
            remainder = (remainder+nums[i])%k;
            System.out.println("remainder:"+remainder);
            if(map.containsKey(remainder)){
                int preIndex = map.get(remainder);
                if(i-preIndex>=2){
                    return true;
                }
            }else{
                map.put(remainder,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        SubarraySum subarraySum = new SubarraySum();
        int[] nums ={23,2,6,4,7};
        int k = 6;
        System.out.println(subarraySum.checkSubarraySum(nums, k));
    }


}
