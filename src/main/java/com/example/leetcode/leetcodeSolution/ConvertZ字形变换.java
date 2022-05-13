package com.example.leetcode.leetcodeSolution;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class ConvertZ字形变换 {
    public static String convert(String s, int numRows) {
        if (numRows == 1){
         return s;
        }
        //使用StringBuilder
        StringBuilder[] ss = new StringBuilder[numRows];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = new StringBuilder();
        }
        //标识符号
        int index = 0;
        boolean sign = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (index==0 || index == numRows-1){
                sign = !sign;
            }
            ss[index] = ss[index] .append(s.charAt(i));
            if (sign)index++;
            if (!sign)index--;
        }
        for (int i = 0; i < ss.length; i++) {
            result.append(ss[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String convert = convert("PAYPALISHIRING", 3);
        System.out.println(convert);
    }
}
