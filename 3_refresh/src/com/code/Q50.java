package com.code;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
public class Q50 {
    public static void main(String[] args) {
        System.out.println(pow(2, -4));
    }

    public static double pow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n < 0) x = 1 / x;
        double result = 1.0d;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                result *= x;
            }
            x *= x;
        }
        return result;
    }
}
