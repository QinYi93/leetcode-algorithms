package stackPriorityQueue;

import java.util.Stack;

/**
 * This class
 * //只适合之后加减的运算，并且把减号看作加号
 * time: O(n)
 * space:O(n)
 * @author Yi Qin
 * @date 2018-05-06
 */
public class BasicCalculator224 {
    public static void main(String[] args) {
        calculate("123+45-(1+2)");
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                //这里在计算结果
                res += num * sign;
            }else if (s.charAt(i) == '+'){
                sign = 1;
            }else if(s.charAt(i) == '-'){
                sign = -1;
            }else if(s.charAt(i) == '('){
                //先放res, 再放sign, 然后再把结果和sign清零
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if(s.charAt(i) == ')'){
                //把括号里的结果与括号前面的符号相加在把括号以前的结果相加
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
