package math;

/**
 * This class
 * time:O(n) space:O(n)
 * @author Yi Qin
 * @date 2018-04-24
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                //如果已经发现一个不小于9的+1操作完成直接return
                return digits;
            }else{
                //大于9就需要一个进位
                digits[i] = 0;
            }
        }
        //如果运行到这里说明是需要最高位加一，也就是说现在digits[]都是0
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
