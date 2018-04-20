package Math;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-19
 */
public class Pow50 {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 3));
    }
    public static double myPow(double x, int n) {
        double res = cal(x, Math.abs(n));
        if (n > 0) {
            return res;
        } else
            return 1 / res;
    }

    public static double cal(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = cal(x, n / 2);
        if (n % 2 == 1) {
            return res * res * x;
        }else
            return res * res;
    }

}
