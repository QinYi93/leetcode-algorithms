package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class 把俩个数不断的合并成一个数，然后直到最后只剩下一个数，查看最后一个数是否为24
 * 因为是doube型所以需要一个eps变量来判断
 *
 * @author Yi Qin
 * @date 2018-05-15
 */
public class Game24_679 {
    //俩个方法里都可以使用，因为最后返回值是true or false.
    boolean res = false;
    //足够小就可以可以任意
    final double eps = 0.001;
    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();
        for(int n : nums) arr.add((double)n);
        helper(arr);
        return res;
    }
    public void helper(List<Double> arr){
        if(res) return;
        if(arr.size() == 1){
            if(Math.abs(arr.get(0) - 24) < eps)
                res = true;
            return;
        }
        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < i; j++){
                //存新的结果用来
                List<Double> next = new ArrayList<>();
                Double p1 = arr.get(i), p2 = arr.get(j);
                //把俩个数加减乘除的结果加进去
                next.addAll(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));
                //除的时候要注意分母不为零
                if(Math.abs(p2) > eps) next.add(p1/p2);
                if(Math.abs(p1) > eps) next.add(p2/p1);
                //移动在这个index的元素
                arr.remove(i);
                arr.remove(j);
                for(Double n: next){
                    arr.add(n);
                    helper(arr);
                    //移走刚刚加上去的那个元素
                    arr.remove(arr.size() - 1);
                }
                //在j的位置上加上p2, add（index, element)
                arr.add(j, p2);
                arr.add(i, p1);
            }
        }
    }
}
