package com.example.leetcode.leetcodeSolution;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome最长回文子串 {

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

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
//        dp[i][j]表示第i个元素到第j个元素是否是回文
        int[][] dp = new int[len][len];
        int max = 1;
        int maxi = 0;
        int maxj = 0;

        //初始化，一个元素一定是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int j = 0; j < len; j++){
            for(int i = 0; i < j; i++){
                if (s.charAt(i) == s.charAt(j) && ((j-i<=2) || (dp[i+1][j-1] == 1))) {
                    dp[i][j] = 1;

                    //最长计算
                    if (j-i+1 > max) {
                        maxi = i;
                        maxj = j;
                        max = j-i+1;
                    }
                }
            }
        }
        return s.substring(maxi, maxj+1);
    }

    public static void main(String[] args) {
        String babad = longestPalindrome("babad");
        String babad2 = longestPalindrome2("babad");
        System.out.println("---");
    }
}
