package array;

/**
 * This class
 * find the rule !!!
 * time: O(n)
 * space: O(1)
 * @author Yi Qin
 * @date 2018-04-23
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums == null)
            return;
        int left = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                left = i;
                break;
            }
        }
        if(left == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int right = -1;
        for(int i = nums.length - 1; i > left; i--){
            if(nums[left] < nums[i]){
                swap(nums, left, i);
                right = i;
                break;
            }
        }
        reverse(nums, left + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //颠倒一个已经成为降序的序列！！！
    public void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i++, j--);
        }
    }
}
