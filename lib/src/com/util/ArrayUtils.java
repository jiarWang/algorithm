package com.util;

import java.util.Random;

public class ArrayUtils {
    public static void swap(int[] array, int source, int target){
        int tmp = array[source];
        array[source] = array[target];
        array[target] = tmp;
    }

    public static void print(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append("," + i);
        }
        if (sb.length() > 0) {
            System.out.println(sb.substring(1));
        }
    }

    public static int[] newData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = new Random().nextInt(size * 10);
        }
        return data;
    }
}
