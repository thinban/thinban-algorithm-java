package com.thinban.stackAndQueue;

import java.util.Stack;

/**
 * 栈实现队列:
 *
 * @author chenshengbin
 * @date 2022/1/11 17:14
 */
class MyQueue {

    Stack<Integer> s1 = null;
    Stack<Integer> s2 = null;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        while (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        final Integer pop = s1.pop();
        return pop;
    }

    public int peek() {
        while (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        final MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
    }
}

