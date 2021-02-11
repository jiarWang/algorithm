package com.code;

import com.util.ArrayUtils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * //大顶堆
 */
public class Q239 {

    public static void main(String[] args) {
        ArrayUtils.print(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> indexQueue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, 0);
        for (int i = 0; i < nums.length; i++) {
            //从后往前，移除小于当前值得index
            while (!indexQueue.isEmpty() && nums[indexQueue.peekLast()] < nums[i]) {
                indexQueue.pollLast();
            }
            //新加index
            indexQueue.addLast(i);
            //移除窗口外的index
            if (indexQueue.peek() <= i - k) {
                indexQueue.poll();
            }
            if (i >= k - 1) {
                result[i - (k - 1)] = nums[indexQueue.peek()];
            }
            //取值
        }
        return result;
    }
}
