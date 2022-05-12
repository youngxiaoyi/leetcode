package com.example.leetcode.leetcodeSolution;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String result = "";
        int max = 0;
        int left;
        int right;
        for (int i = 0; i < s.length(); i++) {
            //初始化
            left = right = i;
            //确定中心，有相同字符则最长相同字符为中心
            while(right +1  < s.length()) {
                if (s.charAt(right +1) == s.charAt(left)) {
                    right++;
                } else {
                    break;
                }
            }
            //开始扩散
            while (left-1 >= 0 && right+1  < s.length()) {
                if (s.charAt(left-1) == s.charAt(right+1)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            //计算最长字符串
            if (right - left + 1 > max) {
                max = right - left + 1;
                result = s.substring(left, right+1);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        String babad = longestPalindrome("cccccc");
        System.out.println("---");
    }
}
