package math;

/**
 * This class
 * 2 -> 10
 * 4 -> 100
 * 8 -> 1000
 *        &
 *      0111
 *      0000 = 0
 *
 * time: O(1)  space: O(1)
 *
 *
 * @author Yi Qin
 * @date 2018-05-07
 */
public class PowerofTwo231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }
}
