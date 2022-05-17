package com.example.leetcode.leetcodeSolution;

import java.util.HashMap;

/**
 * . 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 */
public class MyAtoi字符串转整数 {
    public static void main(String[] args) {
        int i = myAtoi("   -121231231231231233aaaa");
        System.out.println(i);
    }

    /**
     * 自动机map
     */
    static HashMap<String, String[]> map = new HashMap(){{
        put("start", new String[]{"start", "sign", "num","end"});
        put("sign", new String[]{"end", "end", "num","end"});
        put("num", new String[]{"end", "end", "num","end"});
        put("end", new String[]{"end", "end", "end","end"});
    }};
    private static String status = "start";
    private static int sign = 0;
    private static long res = 0;
    public static int myAtoi(String s) {
        int len = s.length();
        int  num = 0;
        int  sign = 1;

        for (int i = 0; i < len; i++) {
            get(s.charAt(i));
        }
        long result  = sign * res;
        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    private static void get(char chars){
        status = map.get(status)[getCol(chars)];
        if ("num".equals(status)) {
            res = res * 10 + chars-'0';
        }
        if ("sign".equals(status) && '-' == chars) {
            sign = -1;
        }
    }

    private static int getCol (char col) {
        if (col == ' ') {
            return 0;
        }

        if (col == '-') {
            return 1;
        }
        if (Character.isDigit(col)) {
            return 2;
        }
        return 3;
    }
}
