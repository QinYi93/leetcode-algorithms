package binaryindextree;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-29
 */

class RangeSumQueryMutable307 {
    int[] nums;
    int[] tree;
    int n;
    public RangeSumQueryMutable307(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n];
        for(int i = 0; i < n; i++){
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        if(n == 0) return;
        int diff = val - nums[i];
        nums[i] = val;
        for(int j = i + 1; j <= n; j += j &(-j)){
            tree[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int k){
        int sum = 0;
        for(int i = k; i > 0; i -= i & (-i)){
            sum += tree[i];
        }
        return sum;
    }
}

class Test{
    public static void main(String[] args) {
        RangeSumQueryMutable307 ins = new RangeSumQueryMutable307(new int[]{1, 3, 5});
        ins.update(1, 2);
        ins.sumRange(0, 2);
    }
}

