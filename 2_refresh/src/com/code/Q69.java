package com.code;

import java.util.Arrays;

/**
 *
 * 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q69 {
    public static void main(String[] args) {

    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int res = nums[0];
        for(int i : nums){
            if(count == 0){
                res = i;
            }
            if(res == i){
                count ++;
            }else{
                count --;
            }
        }
        return res;
    }

    /**
     *
     */

    public static int majorityElement_(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
