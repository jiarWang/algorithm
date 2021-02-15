package com.code;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口的最大值
 *
 *
 */
public class Q239 {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7,}, 3);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> indexQueue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, 0);

        for (int i = 0; i < nums.length; i++) {
            //移除旧的、小的元素
            while(!indexQueue.isEmpty() && nums[indexQueue.peekLast()] < nums[i]){
                indexQueue.pollLast();
            }
            //加入新的
            indexQueue.offer(i);
            //移除窗口外的
            if (indexQueue.peekFirst() + k <= i){
                indexQueue.pollFirst();
            }
            if (i >= k -1){
                result[i - (k - 1)] = nums[indexQueue.peekFirst()];
            }
        }
        return result;
    }
}
