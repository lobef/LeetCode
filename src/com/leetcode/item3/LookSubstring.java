package com.leetcode.item3;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 *
 * 示例1:
 *
 * 输入:s="abcabcbb"
 * 输出:3
 * 解释:因为无重复字符的最长子串是"abc"，所以其长度为3。
 * 示例2:
 *
 * 输入:s="bbbbb"
 * 输出:1
 * 解释:因为无重复字符的最长子串是"b"，所以其长度为1。
 * 示例3:
 *
 * 输入:s="pwwkew"
 * 输出:3
 * 解释:因为无重复字符的最长子串是"wke"，所以其长度为3。
 * 请注意，你的答案必须是子串的长度，"pwke"是一个子序列，不是子串。
 * 示例4:
 *
 * 输入:s=""
 * 输出:0
 *
 *
 * 提示：
 *
 * 0<=s.length<=5*104
 * s由英文字母、数字、符号和空格组成
 */
public class LookSubstring {

    public int lengthOfLongestSubstring(String s){
        // 方法一
//        if(!"".equals(s)){
//            int max = 0;
//           for(int i=1;i<=s.length();i++){
//               int start = 0 ,end = start+i;
//               while(end<=s.length()){
//                   String sub = s.substring(start,end);
//                   Set<String> set = new HashSet(Arrays.asList(sub.split("")));
//                   if(set.size()==i){
//                       max = Math.max(i,max);
//                   }
//                   start++;
//                   end++;
//               }
//           }
//           return max;
//        }
        // 方法二
        Set<Character> chars = new HashSet<>();
        int rk=-1 ,ans=0;
        for(int i=0;i<s.length();i++){
            if(i!=0){
                chars.remove(s.charAt(i-1));
            }
            while (rk + 1 < s.length() && !chars.contains(s.charAt(rk + 1))) {
                chars.add(s.charAt(rk + 1));
                ++rk;
            }

            ans = Math.max(ans,rk-i+1);


        }
        return ans;
    }

    public static void main(String[] args) {
        LookSubstring ls = new LookSubstring();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ls.lengthOfLongestSubstring(""));

        System.out.println(ls.lengthOfLongestSubstring(" "));

    }

}
