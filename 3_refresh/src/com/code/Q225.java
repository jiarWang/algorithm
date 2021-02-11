package com.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用链表实现堆栈
 */
public class Q225 {
    public static void main(String[] args) {

    }


    static class MyStack {

        private Queue<Integer> a = new LinkedList<>();
        private Queue<Integer> b = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            b.offer(x);
            while (!a.isEmpty()){
                b.offer(a.poll());
            }
            Queue tmp = a;
            a = b;
            b = tmp;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return a.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return a.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return a.isEmpty();
        }
    }
}
