package dp;

/**
 * This class
 * time: O(n^3)
 * space: O(n^2)
 * method: dpf + memor
 *
 * eg: nums : 3 1 5 8
 *     arr: 1 3 1 5 8 1
 *            i   x j
 *            把x看成最后一个加进去的 nums[i-1] * nums[x] * nums[j+1]
 *            dp[i][j] = max(dp[i][j], dp[i][x-1] + dp[x+1][j] + nums[i-1] * nums[x] * nums[j+1])
 *            代表打破的气球在i, j之间
 * @author Yi Qin
 * @date 2018-05-08
 */
public class BurstBalloons312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        for(int i = 0; i< n; i++){
            arr[i+1] = nums[i];
        }
        arr[0] = arr[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        return helper(1, n, arr, dp);
    }
    public int helper(int i, int j, int[] nums, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] > 0) return dp[i][j];
        for(int x = i; x <= j; x++){
            dp[i][j] = Math.max(dp[i][j], helper(i, x - 1, nums, dp)
                    + nums[i-1]*nums[x]*nums[j+1]
                    + helper(x+1, j, nums, dp));
        }
        return dp[i][j];
    }
}
