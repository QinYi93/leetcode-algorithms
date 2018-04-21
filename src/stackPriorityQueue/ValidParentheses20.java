package stackPriorityQueue;

import java.util.Stack;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-04-21
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(Character ch: s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }else if(ch == '['){
                stack.push(']');
            }else if(ch == '{'){
                stack.push('}');
            }else{
                if(stack.isEmpty() || stack.pop() != ch)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
