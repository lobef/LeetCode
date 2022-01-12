package com.leetcode.item7;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 */
public class IntegerReverse {

    public static void main(String[] args) {
        int x = 123;
//        System.out.println(reverse(x));
//        x = 120;
//        System.out.println(reverse(x));
        x = -2147483648;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        if (x < 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        long result = Long.parseLong(sb.toString());
        return result > Integer.MAX_VALUE ? 0 : x < 0 ? -(int) result : (int) result;
    }

    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int num = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            result = result * 10 + num;
        }

        return result;
    }
}
