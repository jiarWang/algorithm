package com.code;

public class Q69 {
    public static void main(String[] args) {
        System.out.println(sqrt(2147395599));
    }

    public static int sqrt(int d){
        if (d == 0 || d == 1) return d;
        int left = 0, right = d;
        int ans = left;
        while (left <= right){
            int middle = left + (right - left)/2;
            if (middle == d/middle) return middle;
            else if (middle > d/middle){
                right = middle - 1;
            }else {
                ans = middle;
                System.out.println(ans);
                left = middle + 1;
            }
        }
        return ans;
    }
}
