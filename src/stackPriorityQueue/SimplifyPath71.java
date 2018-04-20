package stackPriorityQueue;

import java.util.Stack;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-23
 */
public class SimplifyPath71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/"));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] input = path.split("/+");
        int i = 0;
        while (i < input.length) {
            if (input[i].equals("..")) {
                if (!stack.empty())
                    stack.pop();
            } else if (!input[i].equals(".") && !input[i].equals("")) {
                stack.push(input[i]);
            }
            i++;
        }

        String output = new String();
        while (!stack.empty()) {
            output = "/" + stack.pop() + output;
        }
        return output.length() == 0 ? "/" : output;
    }
}
