package com.code;

import com.util.ArrayUtils;

import java.util.*;

/**
 * 三数之和
 * <p>
 * sort 加 双指针
 */
public class Q15 {
    public static void main(String[] args) {
        int[] ints = ArrayUtils.newData(12);
        ArrayUtils.print(ints);
        int[] nums = {34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49};
        ArrayUtils.print(nums);
        quickSort(nums);
        threeSum(nums);
        ArrayUtils.print(nums);
        ArrayUtils.check(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
       Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > -nums[i]) {
                    right--;
                } else if (sum < -nums[i]) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    private static void quickSort(int[] array) {
        if (array == null) return;
        quickSort(array, 0, array.length - 1);
    }


    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int privot = privot(array, start, end);
        quickSort(array, start, privot);
        quickSort(array, privot + 1, end);
    }

    private static int privot(int[] array, int start, int end) {
        int privot = start, l = start, r = end;
        while (l < r) {
            while (l < r && array[r] >= array[privot]) {
                r--;
            }
            while (l < r && array[l] <= array[privot]) {
                l++;
            }
            ArrayUtils.swap(array, l, r);
        }
        ArrayUtils.swap(array, privot, l);
        return l;
    }

    /**
     * 此法不行
     */
//    public static List<List<Integer>> threeSum(int[] nums) {
//
//        if (nums == null) return Collections.emptyList();
//        List<List<Integer>> result = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
    //map的key存在冲突，所以此法行不通
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                Integer value = map.get(-(nums[i] + nums[j]));
//                if (value instanceof Integer && value > j) {
//                    O o = new O(nums[i], nums[j], nums[value]);
//                    if (result.contains(o)) break;
//                    result.add(o);
//                }
//            }
//        }
//        return result;
//    }

//    static class O extends ArrayList<Integer> {
//        int max;
//        int min;
//        public O(int a, int b, int c) {
//            super(Arrays.asList(a, b, c));
//            max = Math.max(a, Math.max(b, c));
//            min = Math.min(a, Math.min(b, c));
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            O integers = (O) o;
//            return max == integers.max && min == integers.min;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(max, min);
//        }
//    }
}
