package com.example.leetcode.leetcodeSolution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        //队列
        Deque<Character> deque = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            //没有字符往队列中添加元素
            if (!deque.contains(s.charAt(i))) {
                deque.addFirst(s.charAt(i));
            }
            //已经存在元素则从头删除到该元素，然后添加
            else {
                boolean isContinueDel = true;
                while (isContinueDel) {
                    char delChar = deque.removeLast();
                    if (delChar == s.charAt(i)) {
                        isContinueDel = false;
                    }
                }
                deque.addFirst(s.charAt(i));
            }
            //统计当前存在是否为最长
            max = Math.max(max, deque.size());
        }
        return max;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println("---");

    }
}
