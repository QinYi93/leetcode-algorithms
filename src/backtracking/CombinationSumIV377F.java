package backtracking;

import java.util.HashMap;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-03
 */
public class CombinationSumIV377F {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.print(combinationSum(nums, 4));
    }
    //dp 解法  O(n*k) space O(k)
    public static int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    res[i] += res[i-num];
                }
            }
        }
        return res[target];
    }

    public static int combinationSum(int[] nums, int target) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(nums, target, map);
    }

    public static int helper(int[] nums, int target, HashMap<Integer, Integer> map) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (map.containsKey(target)) return map.get(target);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += helper(nums, target - nums[i], map);
        }
        map.put(target, res);
        return res;
    }
}
/*
target : 4     3    2    1    0

i:       0  -> 0 -> 0 -> 0 -> 0
res:                     1 <- 1
i                        1
res                      1+h(-1) -> h(-1)=0
                         1       <-
i                        2
res                      1+0
                         map(1, 1)
--------
target: 2  1
i:0       res:1
i:1       res:2
i:1       res:2+0       map(2, 2)   return 2
--------
target: 3
i:0     res:2
i:1     res:2+1=3
i:2     res:3+1=4       map(3, 4)   return 4
--------
target: 4
i:0     res:4
i:1     res:4+h(4-2)=6
i:2     res:6+h(1)=7    map(4, 7)   return 7




 */
