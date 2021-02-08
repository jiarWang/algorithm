package com.code;

import com.code.util.Utils;
import com.struct.ListNode;
import com.util.ArrayUtils;
import com.util.ListUtils;

import java.util.Arrays;

/**
 * 数据流中第k大的数或第k小的数
 * <p>
 * 一刷：第k大
 * 二刷：第k小
 */
public class Q703 {
    public static final String TAG = Q703.class.getSimpleName();

    public static void main(String[] args) {
        System.out.println(TAG);
        int[] ints = ArrayUtils.newData(12);
        ArrayUtils.print(ints);
        System.out.println(kMin(ints, 4));
        Sort.quickSort(ints);
        ArrayUtils.print(ints);
    }

    public static int kMin(int[] nums, int k) {
        int[] maxGroup = Arrays.copyOfRange(nums, 0, k);
        if (nums.length == k){
            minHeap(maxGroup);

        }else {
            int index = k;
            while (index < nums.length && nums[index] > maxGroup[0]){
                maxGroup[0] = nums[index];
                minHeap(maxGroup);
                index ++;
            }
        }
        return maxGroup[0];
    }

    public static void minHeap(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            heapfy(array, i);
        }
    }

    private static void heapfy(int[] array, int currentIndex) {
        int left = 2 * currentIndex + 1;
        int right = left + 1;
        int minIndex = currentIndex;
        if (left < array.length) {
            minIndex = array[minIndex] < array[left] ? minIndex : left;
        }
        if (right < array.length) {
            minIndex = array[minIndex] < array[right] ? minIndex : right;
        }
        if (minIndex != currentIndex) {
            ArrayUtils.swap(array, currentIndex, minIndex);
            heapfy(array, minIndex);
        }
    }
}
