package com.code;

/**
 * 平方根
 */
public class Q69 {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int left = 0, right = x;
        //[left, middle) && (middle, right]
        int result = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int i = middle * middle;
            if (x/middle == middle){
                return middle;
            }else if (x/middle > middle){
                //结果太小，取右侧
                result = middle;
                left = middle + 1;

            }else{
                //结果太大，去左侧
                right = middle - 1;
            }
        }
        return result;
    }
}
