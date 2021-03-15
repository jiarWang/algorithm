
import com.util.ArrayUtils;

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


    public static int[] newData(int size) {
        int[] DATA = new int[size];
        for (int i = 0; i < size; i++) {
            DATA[i] = new Random().nextInt(size * 10);
        }
        return DATA;
    }

    public static void main(String[] args) {
        int[] ints = newData(3000);
        insertSort(ints);
        ArrayUtils.print(ints);
        check(ints);
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) ArrayUtils.swap(array, j, j + 1);
            }
        }
    }

    /**
     * 选择排序
     * <p>
     * 冒泡排序比较后需要交换相邻的元素，而选择排序交换的次数比较少
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minDex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minDex]) minDex = j;
            }
            ArrayUtils.swap(array, minDex, i);
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            while (j >= 0 && array[j] > array[j + 1]) {
                ArrayUtils.swap(array, j, j + 1);
                j--;
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param array
     */
    public static void shellSort(int[] array) {

    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] array) {

    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] array) {

    }


    public static void check(int[] array) {
        System.out.println("---检测开始---");
        if (array == null) return;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                throw new RuntimeException(
                        String.format("排序结果有误 array[%d] = %d > array[%d] = %d", i - 1, array[i - 1], i, array[i])
                );
            }
        }
        System.out.println("---检测通过---");
        return;
    }
}
