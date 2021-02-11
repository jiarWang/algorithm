package com.code;

/**
 * x的n次幂
 */
public class Q50 {
    public static void main(String[] args) {
        System.out.println(pow(2.00000, -2147483648));
        System.out.println(3 & 1);
    }

//    public static double pow(double x, int n) {
//        if (n == 0) return 1.0d;
//        if (n == 1) return x;
//        if (n == -1) return 1.0d/x;
//        double half = pow(x,  n / 2);
//        return pow(x, n%2) * half * half;
//    }

    public static double pow(double x, int n) {
        double pow = 1.0d;
        //110011011
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                pow *= x;
            }
            x *= x;
        }
        return n > 0 ? pow : 1 / pow;
    }
}
