package array;

import java.util.ArrayList;
import java.util.List;

/**
 * This class
 * time: O(n)
 * space:O(N)
 * 暴力解法
 * @author Yi Qin
 * @date 2018-05-03
 */
public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            while(i<nums.length-1 && nums[i]+1 == nums[i+1]){
                i++;
            }
            if(num != nums[i]){
                res.add(num+"->"+nums[i]);
            }else{
                res.add(num+"");
            }
        }
        return res;
    }
}
