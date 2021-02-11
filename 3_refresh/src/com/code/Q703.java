package com.code;

import com.struct.TreeNode;
import com.util.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中第k大的数或第k小的数
 * <p>
 * 一刷：第k大
 * 二刷：第k小
 * <p>
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 */
public class Q703 {
    public static void main(String[] args) {
        int[] ints = ArrayUtils.newData(12);
        ArrayUtils.print(ints);
    }

    static class KthLargest {
        //小顶对
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int mK;

        public KthLargest(int k, int[] nums) {
            mK = k;
            for (int i = 0; i < nums.length; i++) {
                if (i >= k && nums[i] > queue.peek()) {
                    //比堆顶小的忽略，比堆顶大的加入并移除堆顶
                    queue.poll();
                    queue.add(nums[i]);
                }else {
                    queue.add(nums[i]);
                }
            }

        }

        public int add(int val) {
            //比堆顶小的忽略，比堆顶大的加入并移除堆顶
            if (queue.size() < mK) {
                queue.add(val);
                return queue.peek();
            }
            if (val > queue.peek()) {
                queue.poll();
                queue.add(val);
            }
            return queue.peek();
        }
    }

}
