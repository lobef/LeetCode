package com.leetcode.item6;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(convert("ABewrwe", 3));
    }

    public static String convert(String s, int numRows) {
        int length = s.length();
        if (length <= 0 || length <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int row = 0;
        int index = 0;
        while (index < length) {
            while (index < length && row < numRows) {
                builders[row++].append(s.charAt(index++));
            }
            if (index == length) {
                break;
            }
            row--;
            while (index < length && row > 0) {
                builders[--row].append(s.charAt(index++));
            }
            row++;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : builders) {
            result.append(builder);
        }
        return result.toString();
    }
}
