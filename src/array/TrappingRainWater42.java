package array;

/**
 * This class
 *time: O(n)
 * space: O(1)
 * @author Yi Qin
 * @date 2018-04-23
 */
public class TrappingRainWater42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
