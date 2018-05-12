package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-12
 */
public class PalindromePairs336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        //用hashmap 的原因是因为最后返回的是index所以 要找string 对应的index
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<words.length; i++){
            map.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++){
            //注意这块取等号因为substring 函数去不到j
            for(int j = 0; j <= words[i].length(); j++){
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1)){
                    //利用stringbuilder 翻转字符串
                    String str2R = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2R) && map.get(str2R) != i){
                        //把array变成一个list
                        res.add(Arrays.asList(map.get(str2R), i));
                    }
                }
                //要判断是否为空
                if(str2.length() != 0 && isPalindrome(str2)){
                    String str1R = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1R) && map.get(str1R) != i){
                        //放入的顺序和前一个是不同的
                        res.add(Arrays.asList(i, map.get(str1R)));
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String word){
        //注意这里不需要判断是否为空
        int start = 0;
        int end = word.length() - 1;
        //start 和 end 是可以相等的当有 基数个单词的时候
        while(start <= end){
            if(word.charAt(start) != word.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
