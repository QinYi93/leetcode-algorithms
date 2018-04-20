package stackPriorityQueue;

import java.util.Stack;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-22
 */
public class MyQueue {
    Stack<Integer> queue;
    Stack<Integer> helper;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        queue = new Stack<Integer>();
        helper = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (queue.empty()) {
            queue.push(x);
        } else {
            while (!queue.empty()) {
                helper.push(queue.pop());
            }
            queue.push(x);
            while (!helper.empty()) {
                queue.push(helper.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return queue.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return queue.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return queue.empty();
    }
}

