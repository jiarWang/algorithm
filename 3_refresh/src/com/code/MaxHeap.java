package com.code;

import com.util.ArrayUtils;

/**
 * 大顶堆
 */
public class MaxHeap {
    public static void main(String[] args) {

    }

    public static void maxHeapfy(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapfy(nums, i);
        }
    }

    public static void heapfy(int[] nums, int current) {
        int left = 2 * current + 1;
        int right = left + 1;
        int maxIndex = current;
        if (left < nums.length && nums[maxIndex] < nums[left]) {
            maxIndex = left;
        }
        if (right < nums.length && nums[maxIndex] < nums[right]) {
            maxIndex = right;
        }
        if (maxIndex != current) {
            ArrayUtils.swap(nums, current, maxIndex);
            heapfy(nums, maxIndex);
        }
    }
}
