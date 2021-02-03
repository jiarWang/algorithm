package com.code;

public class Utils {

    public static void swap(int[] array, int source, int target){
        int tmp = array[source];
        array[source] = array[target];
        array[target] = tmp;
    }

    public static void print(int[] array){
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append("," + i);
        }
        if (sb.length() > 0){
            System.out.println(sb.substring(1));
        }
    }
}
