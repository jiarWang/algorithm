package com.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用链表实现堆栈
 */
public class Q225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for (int i = 0; i < 11; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(stack.pop());
        }
    }

    private static class MyStack {
        private Queue<Integer> a = new LinkedList<>();
        private Queue<Integer> b = new LinkedList<>();

        void push(int i) {
            b.offer(i);
            while (!a.isEmpty()) {
                b.offer(a.poll());
            }
            Queue t = b;
            b = a;
            a = t;
        }

        int pop() {
            return a.poll();
        }
    }
}
