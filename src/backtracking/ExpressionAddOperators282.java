package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * This class
 * 2 + 3 * 2  5 - 3 + 3 * 2
 * @author Yi Qin
 * @date 2018-03-06
 */
public class ExpressionAddOperators282 {
    public static void main(String[] args) {
        List<String> output = addOperators("00", 0);
        for (String i: output){
            System.out.println(i);
        }
    }
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    public static void helper(List<String> res, String path, String num, int target, int index,
                              long val, long pre){
        if (index == num.length()){
            if (val == target){
                res.add(path);
                return;
            }
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0')
                break;
            Long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0)
                helper(res, path + cur, num, target, i + 1, cur, cur);
            else {
                helper(res, path + "+" + cur, num, target, i + 1, val + cur, cur);
                helper(res, path + "-" + cur, num, target, i + 1, val - cur, cur);
                helper(res, path + "*" + cur, num, target, i + 1, val - pre + pre * cur, cur * pre);
            }
        }
    }
}
/*








num= "123", target=6
index:0  i:0  cur:1
     ->path=''+'1', index:1, val:'1', pre:'1', i:1, cur:'2',
        ->(+) path= '1+2', index:2, val:1+2, pre:2, i:2, cur:'3'
            ->(+) path='1+2+3', index:3, val:1+2+3, pre:3
            ->(-) path='1+2-3'
            ->(*) path='1+2*3'
          -> for loop index:3 return
        ->(-) path='1-2'
            ->(+) path='1-2+3'
            ->(-) path='1-2-3'
            ->(*) path='1-2*3'
        ->(*) path='1*2'
            ->(+)
            ->(-)
            ->(*)
      for path:'1' i:2 index:1 cur:'23'
            ->(+) path="1+23"
            ->(-) path="1-23"
            ->(*) path="1*23"
for index:0 i:1 cur='12'
for i:2 index:0 cur='123'



 */