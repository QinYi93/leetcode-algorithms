package temp;

import java.util.HashMap;

/**
 * This class
 * c b a c d c b c
 * 0 1 2 3 4 5 6 7
 *
 * map:
 *      b 6
 *      d 4
 * res[4]:
 * start:0 end: 2
 * loop1: c b a
 *  i=0  k 0 minChar = c start = 1
 *       start = 2 minChar = a start = 3
 *       res[0] = a;
 *       end = 4
 *  i = 1 'c d'
 *        minChar = c
 *        start = 5
 *        res[2] = c
 *
 *
 * @author Yi Qin
 * @date 2018-05-12
 */
public class RemoveDuplicateLetters316 {
    public static void main(String[] args) {
        removeDuplicateLetters("cbacdcbc");
    }

    public static String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        char[] res = new char[map.size()];
        int start = 0, end = findMinLastPos(map);
        for(int i = 0; i < res.length; i++){
            char minChar = 'z' + 1;
            for(int k = start; k <= end; k++){
                if(map.containsKey(s.charAt(k)) && minChar > s.charAt(k)){
                    minChar = s.charAt(k);
                    start = k + 1;
                }
            }
            res[i] = minChar;
            map.remove(minChar);
            if(s.charAt(end) == minChar){
                end = findMinLastPos(map);
            }
        }
        return new String(res);
    }

    public static int findMinLastPos(HashMap<Character, Integer> map){
        int min = Integer.MAX_VALUE;
        for(int i: map.values()){
            min = Math.min(min, i);
        }
        return min;
    }
}
