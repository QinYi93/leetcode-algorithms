package binarySearch;

/**
 * This class
 * time: O(logn)
 * space: O(1)
 * 最常用的二分法思想
 * @author Yi Qin
 * @date 2018-05-02
 */
public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (end - start)/2 + start;
            if(nums[mid] > nums[mid + 1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        //为了防止出现 1 2 3 2 1 当遍历到2的时候 2 > 1 但是 3 < 2 所以增加一个判断条件
        if(nums[start] > nums[end])
            return start;
        else return end;
    }
}
