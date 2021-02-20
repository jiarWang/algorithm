package com.code;
//给定一个非负整数 num。
// 对于 0 ≤ i ≤ num 范围中的每个数字 i ，
// 计算其二进制数中的 1 的数目并将它们作为数组返回。
public class Q338 {
    public int[] countBits(int num) {
        int[] count = new int[num];
        for (int i = 1; i < num; i++) {
            if (i%2 == 0){
                //二的倍数
                count[i] = count[i/2];
            }else {
                count[i] = count[i] - 1;
            }
        }
        return count;
    }
}
