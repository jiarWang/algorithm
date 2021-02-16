package com.code;

/**
 * Math.sqrt(double d)的实现
 */
public class Q69 {

    public static void main(String[] args) {
        Q69 q = new Q69();

        System.out.println(q.sqrt(0));
        System.out.println(Math.sqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        return (int) sqrt(x, 0, x / 2);
    }

    public long sqrt(long x, long start, long end) {
        if (end - 1 == start) return start;
        long mid = (start + end) / 2;
        long m2 = mid * mid;
        if (m2 == x) {
            return mid;
        } else if (m2 > x) {
            return sqrt(x, start, mid);
        } else {
            return sqrt(x, mid, end);
        }
    }

    public int sqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid == x) {
                ans = mid;
                break;
            } else if ((long) mid * mid < x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //算法改进
    public static int mySqrt_(int x) {
        if(x == 0 || x == 1) return x;
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == x/mid) {
                ans = mid;
                break;
            } else if (mid < x/mid) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


}
