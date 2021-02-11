package com.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q15 {
    public static void main(String[] args) {
        //-4,-1,-1,0,1,2
        int[] array = null;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (i + j + k == 0) return;
                }
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] array){
        if (array == null || array.length < 3) return Collections.emptyList();
        Arrays.sort(array);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] > 0) break;
            if ( i > 0 && array[i - 1] == array[i]) continue;
            int left = i + 1;
            int right = array.length - 1;
            while (left < right){
                int sum = array[i] + array[left] + array[right];
                if (sum == 0){
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    while (left < right && array[left + 1] == array[left]) left ++;
                    while (left < right && array[right - 1] == array[right]) right--;
                    left ++;
                    right --;
                }else if (sum > 0){
                    right --;
                }else {
                    left ++;
                }
            }
        }
        return result;
    }
}
