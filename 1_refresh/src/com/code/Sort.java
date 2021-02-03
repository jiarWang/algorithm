package com.code;

import com.code.util.Utils;

import java.util.Arrays;
import java.util.Random;

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

    public static final int SIZE = 2000;
    public static final int[] DATA = new int[SIZE];

    public static int[] newData() {
        for (int i = 0; i < SIZE; i++) {
            DATA[i] = new Random().nextInt(SIZE * 10);
        }
        return DATA;
    }


    public static void main(String[] args) {
//        newData();
//        Utils.print(DATA);
//        long bubbleSortStart = System.currentTimeMillis();
//        bubbleSort(DATA);
//        System.out.println("\n spend :" + (System.currentTimeMillis() - bubbleSortStart));
//        check(DATA);
//        Utils.print(DATA);

//        newData();
//        Utils.print(DATA);
//        long selectSortStart = System.currentTimeMillis();
//        insertSort(DATA);
//        check(DATA);
//        System.out.println("\n spend :" + (System.currentTimeMillis() - selectSortStart));
//        Utils.print(DATA);


        newData();
        Utils.print(DATA);
        quickSort(DATA);
        Utils.print(DATA);
        check(DATA);

    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length; i++) {
            boolean finish = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    Utils.swap(array, j, j + 1);
                    finish = false;
                }
            }
            if (finish) break;
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Utils.swap(array, i, minIndex);
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] array) {
        if (array == null) return;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int tmp = array[i];
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] array) {
        if (array == null) return;
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /**
     * left array = [left,middle]
     * right array = [middle + 1, right]
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] array, int left, int mid, int right) {

        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
        int i = 0, j = 0, currentIndex = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                array[currentIndex] = leftArray[i];
                currentIndex++;
                i++;
            } else {
                array[currentIndex] = rightArray[j];
                currentIndex++;
                j++;
            }
            while (i < leftArray.length) {
                array[currentIndex] = leftArray[i];
                currentIndex++;
                i++;
            }
            while (j < rightArray.length) {
                array[currentIndex] = rightArray[j];
                currentIndex++;
                j++;
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] array){
        if (array == null) return;
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end){
        if (start < end){
            int i = partition(array, start, end);
            quickSort(array, start, i);
            quickSort(array, i + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end){
        if (start >= end) return start;
        int pivot = start;
        int i = start, j = end;
        while (i < j){
            while (j > i && array[j] >= array[pivot]){
                j--;
            }
            while (j > i && array[i] <= array[pivot]){
                i ++;
            }
            Utils.swap(array, i, j);
        }
        Utils.swap(array, i, start);

        return i;
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
