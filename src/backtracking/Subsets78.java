package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-01
 */
public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<Integer>(), nums, 0 );
        return res;
    }
    public static void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int index){
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
