package com.code;

import com.util.ArrayUtils;

import java.util.Arrays;

class KthLargest {

    /**
     * ["KthLargest","add","add","add","add","add","add","add","add"]
     * [[3,[1,1]],[1],[1],[3],[3],[3],[4],[4],[4]]
     *
     * @param args
     */
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{1, 1});
        System.out.println(kthLargest.add(1));
    }

    private int[] maxGroup;
    private int numCount = 0;
    private int k;

    public KthLargest(int k, int[] nums) {
        maxGroup = new int[k];
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                maxGroup[i] = nums[i];
            } else {
                minHeap(maxGroup, -1);
                if (nums[i] > maxGroup[0]) {
                    maxGroup[0] = nums[i];
                }
            }
        }
        numCount = nums.length;
        minHeap(maxGroup, numCount);
    }

    public int add(int val) {
        if (numCount < k) {
            maxGroup[numCount] = val;
            numCount++;
        } else if (val > maxGroup[0]) {
            maxGroup[0] = val;
        }
        minHeap(maxGroup, numCount);
        return maxGroup[0];
    }

    private void minHeap(int[] array, int bound) {
        if (bound < 0) bound = array.length;
        for (int i = (Math.min(bound, array.length) - 1) / 2; i >= 0; i--) {
            heapfy(array, i, bound);
        }
    }

    private void heapfy(int[] array, int currentIndex, int bound) {
        int left = 2 * currentIndex + 1;
        int right = left + 1;
        int minIndex = currentIndex;
        if (left < array.length && left < bound) {
            minIndex = array[minIndex] < array[left] ? minIndex : left;
        }
        if (right < array.length && right < bound) {
            minIndex = array[minIndex] < array[right] ? minIndex : right;
        }
        if (minIndex != currentIndex) {
            swap(array, currentIndex, minIndex);
            heapfy(array, minIndex, bound);
        }
    }

    private void swap(int[] array, int source, int target) {
        int tmp = array[source];
        array[source] = array[target];
        array[target] = tmp;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
