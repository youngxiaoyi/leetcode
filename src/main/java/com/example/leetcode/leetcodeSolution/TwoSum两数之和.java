package com.example.leetcode.leetcodeSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {i, (int) map.get(nums[i])};
            } else {
                map.put(target- nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println("---");
    }
}
