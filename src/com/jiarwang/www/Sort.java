package com.jiarwang.www;

import com.jiarwang.www.util.Utils;

import java.util.Random;

public class Sort {
    private final static int SIZE = 15;
    private static int[] DATA = new int[SIZE];

    static {
        for (int i = 0; i < SIZE; i++) {
            DATA[i] = new Random().nextInt(SIZE * 10);
        }
    }

    public static void main(String[] args) {
        Utils.print(DATA);
        bubblingSort(DATA);
        Utils.print(DATA);
    }


    public static void bubblingSort(int[] array) {
        if (array != null) {
            for (int j = 0; j < array.length; j++) {
                boolean flag = true;
                for (int i = 0; i < array.length - j - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        flag = false;
                        Utils.swap(array, i, i + 1);
                    }
                }
                if (flag) return;
            }
        }
    }
}
