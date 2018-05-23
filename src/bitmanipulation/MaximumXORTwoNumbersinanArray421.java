package bitmanipulation;

import java.util.HashSet;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-18
 */
public class MaximumXORTwoNumbersinanArray421 {
    public static void main(String[] args) {
        int[] arr = {3, 10, 5, 25, 2, 8};
        findMaximumXOR(arr);
    }
    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | 1<<i;
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(mask & num);
            }
            int temp = max | (1 << i);
            for(int pre: set){
                if(set.contains(pre ^ temp)){
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}
