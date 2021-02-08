package com.code;

import com.util.ArrayUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 */
public class Q239 {

    public static void main(String[] args) {
        ArrayUtils.print(maxSlidingWindow(new int[]{7,2,4}, 2));
    }

    public static int[] maxSlidingWindow(int[] array, int k) {
        if(array == null || array.length == 0) return new int[]{};
        int[] result = new int[array.length - k + 1];
        Deque<Integer> indexQuene = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!indexQuene.isEmpty() && array[indexQuene.peekLast()] < array[i]){
                indexQuene.removeLast();
            }
            indexQuene.add(i);
            if (i - indexQuene.peekFirst() >= k){
                indexQuene.removeFirst();
            }
            if (i >= k - 1){
                result[i -k + 1] = array[indexQuene.peekFirst()];
            }
        }
        return result;
    }
}
