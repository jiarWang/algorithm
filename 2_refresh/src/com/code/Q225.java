package com.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用链表实现堆栈
 */
public class Q225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }


    private static class MyStack {

        private Queue<Integer> a = new LinkedList<>();
        private Queue<Integer> b = new LinkedList<>();

        public MyStack() {
        }

        public void push(int i) {
            b.offer(i);
            while (!a.isEmpty()) {
                b.add(a.poll());
            }
            Queue tmp = a;
            a = b;
            b = tmp;
        }

        public int pop() {
            return a.poll();
        }

        public int top() {
            return a.peek();
        }

        public boolean empty() {
            return a.isEmpty();
        }


    }
}
