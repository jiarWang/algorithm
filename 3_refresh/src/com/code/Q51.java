package com.code;

//pow
public class Q51 {
    public static void main(String[] args) {
        System.out.println(myPow(1231.324, -3) - Math.pow(1231.324, -3));
    }

    public static double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1.0d;
        if (n < 0) {
            return 1.0d / myPow(x, -n);
        }
        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);
    }
}
