package com.leetcode.item917;

/**
 * 917. 仅仅反转字母
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 * <p>
 * 示例 1：
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * <p>
 * 示例 2：
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * 示例 3：
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * 提示
 * 1 <= s.length <= 100
 * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
 * s 不含 '\"' 或 '\\'
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("$1:V<&NyJ"));
    }

    /**
     * 我自己想的
     *
     * @param s
     * @return
     */
    public static String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        int k = 0, j = s.length() - 1;
        while (j - k > 1) {
            char ch1 = s.charAt(k);
            char ch2 = s.charAt(j);
            if (Character.isLetter(ch1) && Character.isLetter(ch2)) {
                sb.setCharAt(k, ch2);
                sb.setCharAt(j, ch1);
                k++;
                j--;
            } else if (!Character.isLetter(ch1)) {
                k++;
            } else if (!Character.isLetter(ch2)) {
                j--;
            }
        }
        return sb.toString();
    }

    public static String reverseOnlyLetters2(String s) {
        return null;
    }
}
