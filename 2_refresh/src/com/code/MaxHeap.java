package com.code;

import com.util.ArrayUtils;

/**
 * 大顶堆排序
 */
public class MaxHeap {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] ints = ArrayUtils.newData(10);
        ArrayUtils.print(ints);
        maxHeapify(ints);
        ArrayUtils.print(ints);
    }

    public static void maxHeapify(int[] array){
        if (array == null) return;
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            heapfy(array, i);
        }
    }

    private static void heapfy(int[] array, int currentIndex) {
        int left = 2 * currentIndex + 1;
        int right = left + 1;
        int maxIndex = currentIndex;
        if (left < array.length && array[maxIndex] < array[left]) {
            maxIndex = left;
        }
        if (right < array.length && array[maxIndex] < array[right]) {
            maxIndex = right;
        }
        if (maxIndex != currentIndex) {
            ArrayUtils.swap(array, maxIndex, currentIndex);
            heapfy(array, maxIndex);
        }
    }

}
