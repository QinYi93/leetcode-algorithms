package temp;

import java.util.HashSet;

/**
 * This class
 *time: O(n) space:O()
 * @author Yi Qin
 * @date 2018-04-24
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int res = 0;
        for(int i = 0 ; i<nums.length; i++){
            int down = nums[i] - 1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            int up = nums[i] + 1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            res = Math.max(res, up - down - 1);
        }
        return res;
    }
}
