package com.leetcode.item334;

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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= max) {
                max = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }

}
