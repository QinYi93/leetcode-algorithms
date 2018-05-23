package slideWindows;

import java.util.HashMap;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-15
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters159 {
    public static void main(String[] args) {
        lengthOfLongestSubstringTwoDistinct("eceba");
    }
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        int start = 0, end = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(end < s.length()){
            if(map.size() <= 2){
                map.put(s.charAt(end), end);
                end++;
            }
            if(map.size() > 2){
                int leftMost = s.length();
                for(Integer n: map.values()){
                    leftMost = Math.min(leftMost, n);
                }
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}
