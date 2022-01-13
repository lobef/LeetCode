package com.leetcode.item20;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Solution {

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push('(');
            }
            if (')' == s.charAt(i)) {
                if (stack.isEmpty()||'(' != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
            if ('[' == s.charAt(i)) {
                stack.push('[');
            }
            if (']' == s.charAt(i)) {
                if (stack.isEmpty()||'[' != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
            if ('{' == s.charAt(i)) {
                stack.push('{');
            }
            if ('}' == s.charAt(i)) {
                if (stack.isEmpty()||'{' != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
