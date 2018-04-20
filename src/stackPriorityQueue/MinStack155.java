package stackPriorityQueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-21
 */
public class MinStack155 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int x = stack.pop();
        if (!minStack.empty()) {
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
