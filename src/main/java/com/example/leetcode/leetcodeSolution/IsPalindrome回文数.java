package com.example.leetcode.leetcodeSolution;

/**
 *
 */
public class IsPalindrome回文数 {
    public static boolean isPalindrome(int x) {
        if (x <0) return false;
        int pre = x;
        int res = 0;
        while (x != 0) {
            int dig = x % 10;
            x = x / 10;
            res = res * 10 +dig;
        }
        if (pre == res) return true;
        return false;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(1233211);
        System.out.println(palindrome);

    }
}
