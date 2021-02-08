package com.code;

import com.util.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * two sum
 * three sum
 * 两数之和
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println((twoSum(new int[]{2, 7, 11, 15}, 22)));
    }

//    private static boolean twoSum(int[] ints, int sum) {
//        Set<Integer> set = new HashSet<>();
//        for (int i : ints) {
//            if (set.contains(sum - i)) {
//                return true;
//            }
//            set.add(i);
//        }
//        return false;
//    }

//    public static int[] twoSum(int[] array, int sum) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            map.put(array[i], i);
//        }
//        for (int i = 0; i < array.length; i++) {
//            Integer value = map.get(sum - array[i]);
//            if (value instanceof Integer && value != i) {
//                return new int[]{i, value};
//            }
//        }
//        return new int[]{};
//    }

    /**
     * 使用hashmap找到匹配的对方
     * @param array
     * @param sum
     * @return
     */
    public static int[] twoSum(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer value = map.get(sum - array[i]);
            if (value instanceof Integer && value != i) {
                return new int[]{i, value};
            }
            map.put(array[i], i);
        }
        return new int[]{};
    }
}
