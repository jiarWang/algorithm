package com.jiarwang.www;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 7. 整数反转
 */
public class Q7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int y = 0;
        while (x != 0) {
            if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && x % 10 > 7)) return 0;
            if (y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && x % 10 < -8)) return 0;
            y = 10 * y + x % 10;
            x = x / 10;
        }
        return y;
    }
}
