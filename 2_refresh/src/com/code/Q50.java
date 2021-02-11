package com.code;

/**
 * x的n次幂
 * 50. Pow(x, n)
 */
public class Q50 {
    public static void main(String[] args) {
        System.out.println(pow(2.0d, -2));
    }

//    public static double pow(double x, int n) {
//        if (n == 0) return 1.0;
//        if (n == 1) return x;
//        if (n == -1) return 1.0d / x;
//        double half = pow(x, n / 2);
//        return half * half * pow(x, n % 2);
//    }

    public static double pow(double x, int n) {
        double pow = 1.0d;
        if (n < 0) x = 1.0d/x;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0){
                pow *= x;
            }
            x *= x;
        }
        return pow;
    }
}
