package com.thinban.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225 队列实现栈：（q1是逻辑栈）
 * q1 2,1 | q2 3  ==> q1 | q2 3,2,1 ==> q2|q1 3,2,1
 * ps：
 * 1. poll （null） ,remove (NoSuchElementException)-> [头,尾] <- offer,add （IllegalStateException）
 * peek(null),element（NoSuchElementException）
 * <p>
 * 2. LinkedList基于链表实现
 *
 * @author chenshengbin
 * @date 2022/1/11 17:15
 */
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> tmp = q2;
        q1 = q2;
        q2 = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}