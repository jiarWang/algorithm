package com.jiarwang.www;

import com.jiarwang.www.util.Utils;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    private final static int SIZE = 60000;
    private static int[] DATA = new int[SIZE];

    static {
        for (int i = 0; i < SIZE; i++) {
            DATA[i] = new Random().nextInt(SIZE * 10);
        }
    }

    public static void refresh(){
        for (int i = 0; i < SIZE; i++) {
            DATA[i] = new Random().nextInt(SIZE * 10);
        }
    }

    public static void main(String[] args) {
        shellSort(DATA);
        Utils.print(DATA);
        refresh();
        bubblingSort(DATA);
        Utils.print(DATA);
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubblingSort(int[] array) {
       long start = System.currentTimeMillis();
        if (array != null) {
            for (int j = 0; j < array.length; j++) {
                boolean flag = true;
                for (int i = 0; i < array.length - j - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        flag = false;
                        Utils.swap(array, i, i + 1);
                    }
                }
                if (flag) break;
            }
        }
        System.out.println();
        System.out.println("bubbling : " +(System.currentTimeMillis() - start));
    }

    /**
     * 选择排序
     */
    public static void selectionSort(int[] array) {
        if (array != null) {
            for (int i = 0; i < array.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[minIndex] > array[j]) {
                        minIndex = j;
                    }
                }
                Utils.swap(array, i, minIndex);
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] array) {
        if (array != null) {
            for (int i = 1; i < array.length; i++) {
                int tmp = array[i];
                int j = i;
                while (j > 0 && tmp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                if (j != i) {
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * 希尔排序(有步长的掺入排序)
     * @param array
     */
    public static void shellSort(int[] array) {
        long start = System.currentTimeMillis();
        for (int gap = array.length / 2; gap >= 1; gap = gap / 2) {
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                int j = i - gap;
                while (j >= 0 && tmp < array[j]) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = tmp;
            }
        }
        System.out.println();
        System.out.println("shell : " +(System.currentTimeMillis() - start));
    }
}
