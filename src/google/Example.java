package google;

import java.util.Stack;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-04-25
 */
public class Example {
    public static void main(String[] args) {
        solution("2-4A0r7-4k", 3);
    }
    public static String solution(String S, int K) {
        if(S == null || S.length() == 0) return null;
        char[] ch = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++){
            if(ch[i] != '-'){
                stack.push(Character.toUpperCase(ch[i]));
            }
        }
        String res = "";
        int j = 1;
        int len = stack.size();
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
            if(j != len && j % K == 0){
                res = "-" + res;
            }
            j++;
        }
        return res;
    }
}
