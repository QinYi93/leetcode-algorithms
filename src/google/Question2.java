package google;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-04-26
 */
public class Question2 {
    public static int repeat(String A, String B) {
        if (A == null || A.length() == 0) return -1;
        int count = 1 + B.length() / A.length() +  (B.length() % A.length() != 0 ? 1 : 0);
        for (int i = 0; i < count; i++) {
            String check = new String(new char[i + 1]).replaceAll("\0", A);
            if (check.contains(B)) {
                return i + 1;
            }
        }
        return -1;
    }
}
