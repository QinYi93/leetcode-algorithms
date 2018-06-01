package array;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-06-01
 */
public class CreateMaximumNumber321 {
    public static void main(String[] args) {
        maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        for(int i = Math.max(0, k - n); i <= k && i <= m; i++){
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            //比较俩个数组谁大谁小， 一直取的是最大的那个数组
            if(greater(temp, 0, res, 0)){
                res = temp;
            }
        }
        return res;
    }

    private static int[] merge(int[] nums1, int[] nums2, int k){
        int[] res = new int[k];
        for(int i = 0, j = 0, r = 0; r < k; r++){
            res[r] = greater(nums1, i, nums2, j)? nums1[i++] : nums2[j++];
        }
        return res;
    }

    private static boolean greater (int[] nums1, int i, int[] nums2, int j){
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private static int[] maxArray(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[k];
        for(int i = 0, j = 0; i < n; i++){
            while(n - i > k - j && j > 0 && nums[i] > res[j - 1]){
                j--;
            }
            if(j < k){
                res[j++] = nums[i];
            }
        }
        return res;
    }
}
