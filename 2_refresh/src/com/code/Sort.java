package com.code;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static final int SIZE = 1000;
    public static final int[] DATA = new int[SIZE];

    public static int[] newData() {
        for (int i = 0; i < SIZE; i++) {
            DATA[i] = new Random().nextInt(SIZE * 10);
        }
        return DATA;
    }

    public static void main(String[] args) {
        newData();
        mergeSort(DATA);
        Utils.print(DATA);
        check(DATA);
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] array) {
        if (array == null) return;
        for (int gap = array.length / 2; gap >= 1; gap = gap / 2) {
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                int j = i - gap;
                while (j >= 0 && tmp < array[j]) {
                    Utils.swap(array, i, j);
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
        int index = privot(array, start, end);
        quickSort(array, start, index);
        quickSort(array, index + 1, end);
    }

    private static int privot(int[] array, int start, int end) {
        int privot = start;
        int i = start, j = end;
        while (i < j) {
            while (i < j && array[privot] <= array[j]) {
                j--;
            }
            while (i < j && array[privot] >= array[i]) {
                i++;
            }
            Utils.swap(array, i, j);
        }
        Utils.swap(array, privot, i);
        return i;
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left>= right) return;
        int mid = (left + right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, right);
    }


    private static void merge(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
        int i = 0, j = 0;
        int currentIndex = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                array[currentIndex] = leftArray[i];
                i++;
                currentIndex++;
            } else {
                array[currentIndex] = rightArray[j];
                j++;
                currentIndex++;
            }
        }
        while (i < leftArray.length) {
            array[currentIndex] = leftArray[i];
            i++;
            currentIndex++;
        }
        while (j < rightArray.length) {
            array[currentIndex] = rightArray[j];
            j++;
            currentIndex++;
        }
    }

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
