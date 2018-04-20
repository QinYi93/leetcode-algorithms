package Math;

/**
 * This class
 * 4种方法
 *
 * @author Yi Qin
 * @date 2018-02-19
 */
public class ValidPerfectSquare367 {
    public static void main(String[] args) {
//        System.out.println(isPerfectSquare(5));
    }

    //method 01 暴力解法
//    public boolean isPerfectSquare1(int num) {
//        if (num < 0) return false;
//        if (num == 1) return true;
//        for (int i = 1; i <= num/i; i++) {
//            if (i * i == num) {
//                return true;
//            }
//        }
//        return false;
//    }

    //02 二分法 找到一个中间值，如果这个中间值的平方小于需要的平方，让low等于中间值加一
//    public static boolean isPerfectSquare2(int num) {
//        int low = 1;
//        int high = num;
//        while (low <= high) {
//            long mid = (high - low) / 2 + low;
//            if (mid * mid == num) {
//                return true;
//            } else if (mid * mid < num) {
//                low = (int) mid + 1;
//            } else high = (int) mid - 1;
//        }
//        return false;
//    }

    //03找规律法 完全平方数等于基数的和
//    public static boolean isPerfectSquare(int num) {
//        for (int i = 1; i <= num; i = i + 2) {
//            if (num >= 0) {
//                num -= i;
//            } else break;
//        }
//        if (num == 0) return true;
//        return false;
//    }

    //04牛顿迭代法
    public static boolean isPerfectSquare(int num) {
        int x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

}
