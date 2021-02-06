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

    private static class MyList {
        private Stack<Integer> inputStack = new Stack<>();
        private Stack<Integer> outputStack = new Stack<>();

        public void push(int i) {
            inputStack.push(i);
        }

        public int pop() {
            if (outputStack.empty()) {
                while (!inputStack.empty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.pop();
        }

        public int peek() {
            if (outputStack.empty()) {
                while (!inputStack.empty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.peek();
        }
    }
}
