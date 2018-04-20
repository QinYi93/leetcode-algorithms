package stackPriorityQueue;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-21
 */
public class Runner {
    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
