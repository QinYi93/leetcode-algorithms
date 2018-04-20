package stackPriorityQueue;

import java.util.Stack;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-22
 */
public class EvaluateReversePolishNotation150 {
    public static final String ADD = "+";
    public static final String SUB = "-";
    public static final String MUL = "*";
    public static final String DIV = "/";

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> cal = new Stack<>();
        for (String i : tokens) {
            if (i.equals(ADD)) {
                cal.push(cal.pop() + cal.pop());
            } else if (i.equals(SUB)) {
                int b = cal.pop();
                int a = cal.pop();
                cal.push(a - b);
            } else if (i.equals(MUL)) {
                cal.push(cal.pop() * cal.pop());
            } else if (i.equals(DIV)) {
                int b = cal.pop();
                int a = cal.pop();
                cal.push(a / b);
            } else cal.push(Integer.valueOf(i));
        }
        return cal.pop();
    }
}
