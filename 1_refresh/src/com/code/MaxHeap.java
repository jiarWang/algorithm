package com.code;

import com.util.ArrayUtils;

/**
 * 大顶堆
 */
public class MaxHeap {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] ints = ArrayUtils.newData(100);
        ArrayUtils.print(ints);
        System.out.println(check(ints));
        maxHeapify(ints);
        ArrayUtils.print(ints);
        System.out.println(check(ints));
    }

    public static final void maxHeapify(int[] array) {
        //自右而左，自下而上
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            heapify(array, i);
        }
    }

    private static final void heapify(int[] array, int currentIndex) {
        int left = 2 * currentIndex + 1;
        int right = left + 1;
        int maxIndex = currentIndex;
        if (left < array.length && array[left] > array[maxIndex]) {
            maxIndex = left;
        }
        if (right < array.length && array[right] > array[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != currentIndex) {
            ArrayUtils.swap(array, maxIndex, currentIndex);
            heapify(array, maxIndex);
        }
    }

    private static boolean check(int[] heap){
        for (int i = 0; i < heap.length; i++) {
            int left = 2 * i + 1;
            int right = left + 1;
            if (left < heap.length && right < heap.length){
                if (heap[left] > heap[i] || heap[right] > heap[i]) return false;
            }
        }
        return true;
    }
}
