package com.code;

import java.util.Stack;

/**
 * 用栈实现队列
 * 极客大学：第9课
 *
 * 输入栈、输出栈
 * 每次输出栈检查自身是否为空，如果为空就从读取全部输入栈内容
 */
public class Q232 {
    public static void main(String[] args) {

    }

    public static class MyQueue {
        Stack<Integer> inputs = new Stack<>();
        Stack<Integer> outputs = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inputs.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outputs.empty()){
                while (!inputs.empty()){
                    outputs.push(inputs.pop());
                }
            }
            return outputs.pop();
        }

        /** Get the front element. */
        public int peek() {
            return outputs.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return outputs.empty();
        }
    }
}
