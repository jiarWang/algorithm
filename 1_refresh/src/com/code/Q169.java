package com.code;

import java.util.Arrays;

/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q169 {
    public static void main(String[] args) {

    }

//    public static int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }


    public static int majorityElement(int[] nums){
        int count = 0, res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                res = nums[i];
                ++count;
            }else {
                if (res != nums[i]){
                    --count;
                }else {
                    ++count;
                }
            }
        }
        return res;
    }
}
