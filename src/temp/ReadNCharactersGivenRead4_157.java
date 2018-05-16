package temp;

/**
 * This class
 * 三种情况 1. n < string.length n % 4 == 0
 *         2. n < string.length, n % 4 != 0 n-index < count
 *         3. n > string.length, count < n - index -> count
 * @author Yi Qin
 * @date 2018-05-15
 */
public class ReadNCharactersGivenRead4_157 {
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int index = 0;
        while(true){
            int count = read4(temp);
            count = Math.min(count, n - index);
            for(int i = 0; i < count; i++){
                buf[index++] = temp[i];
            }
            if(n == index || count < 4) return index;
        }
    }


    public int read4(char[] temp){
        return 0;
    }
}
