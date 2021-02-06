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
        System.out.println("");
    }

    private static class MyQueue{
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        public void  add(int i){
            inStack.push(i);
        }

        public void poll(){
            if (outStack.empty()){
                while (!inStack.empty()){
                    outStack.push(inStack.pop());
                }
            }
            outStack.pop();
        }

        public int peek(){
            if (outStack.empty()){
                while (!inStack.empty()){
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean isEmpty(){
            return inStack.empty() && outStack.empty();
        }
    }
}
