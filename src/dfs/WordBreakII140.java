package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class
 * time: O(n^3)
 * space: O(n^3)
 * hard
 * @author Yi Qin
 * @date 2018-05-01
 */
public class WordBreakII140 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        wordBreak(s, wordDict);
    }
    static HashMap<Integer, List<String>> map = new HashMap<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }
    public static List<String> dfs(String s, List<String> wordDict, int start){
        if(map.containsKey(start)){
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if(start == s.length()){
            res.add("");
        }
        for (int end = start + 1; end<=s.length();end++){
            if(wordDict.contains(s.substring(start, end))){
                List<String> list = dfs(s, wordDict, end);
                for (String temp: list){
                    res.add(s.substring(start, end) + (temp.equals("") ? "":" ") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
