package com.leetcode.item14;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 
 */

public class Solution {

    public static void main(String[] args) {

        String[] strs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonStr(prefix, strs[i]);
            if (prefix.length() == 0) {
                return prefix;
            }
        }

        return prefix;
    }

    public static String commonStr(String prefix, String target) {
        int length = Math.min(prefix.length(), target.length());
        int index = 0;
        while (index < length && prefix.charAt(index) == target.charAt(index)) {
            index++;
        }

        return prefix.substring(0, index);
    }


}

