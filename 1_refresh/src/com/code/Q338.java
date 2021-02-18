package com.code;

/**
 * 比特位计数
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q338 {
    public static void main(String[] args) {

    }

    public int[] countBits(int num){
        int[] bits = new int[num];
        bits[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i%2 == 0){
                bits[i] = bits[i/2];
            }else {
                bits[i] = bits[i - 1] + 1;
            }
        }
        return bits;
    }



}
