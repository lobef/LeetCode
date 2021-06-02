package com.leetcode.item1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：nums=[2,7,11,15],target=9
 * 输出：[0,1]
 * 解释：因为nums[0]+nums[1]==9，返回[0,1]。
 * 示例2：
 * <p>
 * 输入：nums=[3,2,4],target=6
 * 输出：[1,2]
 * 示例3：
 * <p>
 * 输入：nums=[3,3],target=6
 * 输出：[0,1]
 * <p>
 * 提示：
 * <p>
 * 2<=nums.length<=104
 * -109<=nums[i]<=109
 * -109<=target<=109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于O(n2)的算法吗？
 */
public class TwoNumSum {

    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        // 方法一
//        for (int i = 0; i < nums.length; i++) {
//            int value = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (value == nums[j]) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return result;
        // 方法二
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        TwoNumSum twoNumSum = new TwoNumSum();
//        System.out.println(Arrays.toString(twoNumSum.twoSum(new int[] {2,7,11,15} ,9)));
//        System.out.println(Arrays.toString(twoNumSum.twoSum(new int[] {3,2,4} ,6)));
//        System.out.println(Arrays.toString(twoNumSum.twoSum(new int[] {3,3} ,6)));
//
//        System.out.println(Arrays.toString(twoNumSum.twoSum(new int[] {0,4,3,0} ,0)));

        System.out.println(Arrays.toString(twoNumSum.twoSum(new int[]{-1, -2, -3, -4, -5}, -8)));
    }
}
