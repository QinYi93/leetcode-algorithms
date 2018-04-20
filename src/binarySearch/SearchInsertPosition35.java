package binarySearch;

import java.awt.image.PackedColorModel;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-26
 */
public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        searchInsert(nums, 2);
    }
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (target > nums[end]) return nums.length;
        if (target < nums[start]) return 0;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                end = mid;
            }else start = mid;
        }
        if (target == nums[start]) return start;
        if (target == nums[end]) return end;
        if (target < nums[start]) return start - 1;
        if (target < nums[end] && target > nums[start]) return end;
        return end;
    }

}
