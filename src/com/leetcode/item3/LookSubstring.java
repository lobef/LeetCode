package com.leetcode.item3;

import java.util.HashSet;
import java.util.Set;

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
