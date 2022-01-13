package com.leetcode.item13;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入:s = "III"
 * 输出: 3
 * 示例2:
 * <p>
 * 输入:s = "IV"
 * 输出: 4
 * 示例3:
 * <p>
 * 输入:s = "IX"
 * 输出: 9
 * 示例4:
 * <p>
 * 输入:s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例5:
 * <p>
 * 输入:s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                sum += 1;
            }
            if ('V' == s.charAt(i)) {
                sum += 5;
                if (i != 0 && 'I' == s.charAt(i - 1)) {
                    sum -= 2;

                }
            }
            if ('X' == s.charAt(i)) {
                sum += 10;
                if (i != 0 && 'I' == s.charAt(i - 1)) {
                    sum -= 2;

                }
            }
            if ('L' == s.charAt(i)) {
                sum += 50;
                if (i != 0 && 'X' == s.charAt(i - 1)) {
                    sum -= 20;

                }
            }
            if ('C' == s.charAt(i)) {
                sum += 100;
                if (i != 0 && 'X' == s.charAt(i - 1)) {
                    sum -= 20;

                }
            }
            if ('D' == s.charAt(i)) {
                sum += 500;
                if (i != 0 && 'C' == s.charAt(i - 1)) {
                    sum -= 200;

                }
            }
            if ('M' == s.charAt(i)) {
                sum += 1000;
                if (i != 0 && 'C' == s.charAt(i - 1)) {
                    sum -= 200;

                }
            }
        }
        return sum;
    }


    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt2(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {

            int value = symbolValues.get(s.charAt(i));
            if (i < s.length() - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }

        }
        return sum;
    }
}
