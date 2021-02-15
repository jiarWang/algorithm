package com.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Q1 {
    public static void main(String[] args) {

    }


    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        Map<Integer, Integer> value_index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer secondIndex = value_index.get(target - nums[i]);
            if (secondIndex instanceof  Integer){
                return new int[]{i, secondIndex};
            }
            value_index.put(nums[i], i);
        }
        return null;
    }
}
