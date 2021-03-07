package com.code;

//152. 乘积最大子数组
public class Q152 {
    public int maxProduct(int[] nums) {
        int preMin = 1;
        int preMax = 1;
        int res = nums[0];
        for (int num : nums) {
            if (num > 0) {
                preMax = Math.max(num, preMax * num);
                preMin = Math.min(preMin * num, num);
            } else {
                int tmpMax = preMax;
                preMax = Math.max(num, num * preMin);
                preMin = Math.min(num, num * tmpMax);
            }
            res = Math.max(res, preMax);
        }
        return res;
    }
}
