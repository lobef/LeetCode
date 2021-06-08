package com.leetcode.item4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个大小分别为m和n的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数。
 * 示例1：
 * 输入：nums1=[1,3],nums2=[2]
 * 输出：2.00000
 * 解释：合并数组=[1,2,3]，中位数2
 * 示例2：
 * 输入：nums1=[1,2],nums2=[3,4]
 * 输出：2.50000
 * 解释：合并数组=[1,2,3,4]，中位数(2+3)/2=2.5
 * 示例3：
 * 输入：nums1=[0,0],nums2=[0,0]
 * 输出：0.00000
 * 示例4：
 * 输入：nums1=[],nums2=[1]
 * 输出：1.00000
 * 示例5：
 * 输入：nums1=[2],nums2=[]
 * 输出：2.00000
 *
 *
 * 提示：
 *
 * nums1.length==m
 * nums2.length==n
 * 0<=m<=1000
 * 0<=n<=1000
 * 1<=m+n<=2000
 * -106<=nums1[i],nums2[i]<=106
 */
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> numSet = new ArrayList<>();
        for(int num:nums1){
            numSet.add(num);
        }
        for(int num:nums2){
            numSet.add(num);
        }

        Collections.sort(numSet);
        int size = numSet.size();
        if(size%2==0){
            return (numSet.get(size/2-1)+numSet.get(size/2))/2.0;
        }
        return numSet.get(size/2);
    }

    public static void main(String[] args) {

        MedianSortedArrays msa = new MedianSortedArrays();
        int [] nums1 = {1}, nums2 = {};
        System.out.println(msa.findMedianSortedArrays(nums1,nums2));
    }
}
