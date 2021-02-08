package com.code;

import com.util.ArrayUtils;

import java.util.Arrays;

/**
 * 排序算法
 * <p>
 * 1、冒泡排序
 * 2、选择排序
 * 3、插入排序
 * 4、希尔排序
 * 5、快速排序
 * 6、归并排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] ints = ArrayUtils.newData(12);
        ArrayUtils.print(ints);
        heapSort(ints);
        check(ints);
        ArrayUtils.print(ints);
    }


    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    ArrayUtils.swap(array, i, j);
                }
            }
        }
    }

    /**
     * 选择排序
     */

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i)
                ArrayUtils.swap(array, minIndex, i);
        }
    }

    /**
     * 插入排序
     */

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp) {
                ArrayUtils.swap(array, j, j + 1);
                j--;
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * 希尔排序
     */

    public static void shellSort(int[] array) {
        if (array == null) return;
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > tmp) {
                    ArrayUtils.swap(array, j, j + gap);
                    j -= gap;
                }
                array[j + gap] = tmp;
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int index = privotIndex(array, start, end);
        quickSort(array, start, index);
        quickSort(array, index + 1, end);
    }

    private static int privotIndex(int[] array, int start, int end) {
        int left = start, right = end, privote = start;
        while (left < right) {
            while (right > left && array[privote] <= array[right]) {
                right--;
            }
            while (right > left && array[privote] >= array[left]) {
                left++;
            }
            ArrayUtils.swap(array, right, left);
        }
        ArrayUtils.swap(array, privote, left);
        return left;
    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] array) {
        heapSort(array, 0, array.length - 1);
    }

    private static void heapSort(int[] array, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        heapSort(array, start, middle);
        heapSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    private static void merge(int[] array, int start, int middle, int end) {
        int[] left = Arrays.copyOfRange(array, start, middle + 1);
        int[] right = Arrays.copyOfRange(array, middle + 1, end + 1);
        int i = 0, j = 0, index = start;
        while (i < left.length && j < right.length){
            if(left[i] < right[j]){
                array[index] = left[i];
                i ++;
            }else {
                array[index] = right[j];
                j ++;
            }
            index ++;
        }
        while (i < left.length){
            array[index] = left[i];
            i ++;
            index ++;
        }
        while (j < right.length){
            array[index] = right[j];
            j ++;
            index ++;
        }

    }

    /**
     * 测试函数
     *
     * @param array
     */
    public static void check(int[] array) {
        System.out.println("---check---");
        if (array == null) return;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                throw new RuntimeException(
                        String.format("排序结果有误 array[%d] = %d > array[%d] = %d", i - 1, array[i - 1], i, array[i])
                );
            }
        }
        return;
    }
}
