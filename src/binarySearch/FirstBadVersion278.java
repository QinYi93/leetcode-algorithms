package binarySearch;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-26
 */
public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = (end - start)/2 + start;
            if (isBadVersion(mid))
                end = mid;
            else start = mid;
        }
        if (isBadVersion(start))
            return start;
        return end;
    }

    boolean isBadVersion(int version) {
        return false;
    }


}
