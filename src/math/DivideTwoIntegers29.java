package math;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-18
 * <p>
 * 分母为零的情况是被java的异常机制handle住的！！！！
 * time O(lgn) space O(lgn)
 */
public class DivideTwoIntegers29 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldividend == 0 || ldividend < ldivisor)
            return 0;
        long lres = divide(ldividend, ldivisor);
        int res;
        if (lres > Integer.MAX_VALUE)
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else res = (int) lres * sign;
        return res;
    }

    //resursion
    public static long divide(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor;
        long multiply = 1;
        while (sum + sum <= dividend) {
            sum += sum;
            multiply += multiply;
        }
        return multiply + divide(dividend - sum, divisor);
    }
}
