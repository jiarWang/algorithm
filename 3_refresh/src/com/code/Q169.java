package com.code;

/**
 * 多数元素
 *
 * 方法一：sort && n.length/2
 * 方法二：摩尔投票法
 */
public class Q169 {
    public int majorityElement(int[] nums){
        int count = 0, res = 0;
        for (int num : nums) {
            if (count == 0){
                res = num;
            }
            if (res == num){
                ++ count;
            }else {
                --count;
            }
        }
        return res;
    }
}
