package com.leetcode.item9;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 * 
 *
 * 提示：
 *
 * -231<= x <= 231- 1
 * 
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isPalindrome3(121));
//        System.out.println(isPalindrome(-121));
    }


    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public static boolean isPalindrome2(int x) {
        String s = String.valueOf(x);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int result = 0;
        while (x != 0) {
            int num = x % 10;
            x /= 10;
            result = result * 10 + num;
            if (result >= Integer.MAX_VALUE / 10) {
                return false;
            }
        }
        return result == y;
    }

}
