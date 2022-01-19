package com.leetcode.item17;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Solution {

    private static Map<Character, String> charStr = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations2("24"));
    }


    // 我自己写的
    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = null;
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            if (result != null) {
                for (String s : result) {
                    for (String str : charStr.get(digits.charAt(i)).split("")) {
                        temp.add(s.concat(str));
                    }

                }
                result = temp;
            } else {
                result = new ArrayList<>(Arrays.asList(charStr.get(digits.charAt(0)).split("")));
            }

        }

        return result;
    }

    // 官网
    // 从深度递归
    public static List<String> letterCombinations2(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtrack(result, charStr, digits, 0, new StringBuffer());
        return result;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    // 官网
    // 从广度
    public static List<String> letterCombinations3(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        LinkedList<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            String digit = charStr.get(digits.charAt(i));
            if (result.size() == 0) {
                for (int m = 0; m < digit.length(); m++) {
                    result.add(sb.append(digit.charAt(m)).toString());
                    sb.delete(0, sb.length());
                }
            } else {
                int length = result.size();
                for (int j = 0; j < length; j++) {
                    sb.append(result.pop());
                    for (int m = 0; m < digit.length(); m++) {
                        result.addLast(sb.append(digit.charAt(m)).toString());
                        sb.delete(sb.length() - 1, sb.length());
                    }
                    sb.delete(0, sb.length());
                }

            }

        }
        return result;
    }
}
