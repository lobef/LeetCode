package com.leetcode.item28;

public class Solution {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

//        int indexNeed = 0;
//        for (int i = 0; i < haystack.length(); i++) {
//            if (indexNeed == needle.length()) {
//                return i - needle.length();
//            }
//            if (haystack.charAt(i) == needle.charAt(indexNeed)) {
//                indexNeed++;
//            } else {
//                indexNeed = 0;
//            }
//        }
//        if (indexNeed != 0) {
//            return haystack.length() - indexNeed;
//        }
        return -1;
    }
}