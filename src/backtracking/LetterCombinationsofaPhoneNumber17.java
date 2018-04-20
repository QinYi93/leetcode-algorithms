package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-04
 */
public class LetterCombinationsofaPhoneNumber17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static String[] maping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", " wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0 || digits == null) return res;
        helper(res, digits, "", 0);
        return res;
    }

    public static void helper(List<String> res, String digits, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = maping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i), index + 1);
        }
    }
}
/*
index:0  i:0  s:a   letters:abc
        -> index:1 letters:def i:0  s:ad  index:2  res: ad
                -> return
           index:1   def   i:1  s:ae  index:2  res:ad, ae
           index:1   def   i:2  s:af  index:2  res:ad, ae, af


 */