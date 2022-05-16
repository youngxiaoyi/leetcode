package com.example.leetcode.leetcodeSolution;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
public class Reverse整数反转 {
    public static int reverse(int x) {
        int res = 0;
        while (x !=0) {
            if (res >Integer.MAX_VALUE /10 || res <Integer.MIN_VALUE/10) {
                return 0;
            }
            int dig = x % 10;
             x = x / 10;
             res = res * 10+ dig;
        }
        return res;
    }

    public static void main(String[] args) {
        int reverse = reverse(-2147483631);
        System.out.println(reverse);
    }
}
