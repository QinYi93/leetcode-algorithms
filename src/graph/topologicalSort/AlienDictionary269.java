package graph.topologicalSort;

import java.util.*;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-24
 */
public class AlienDictionary269 {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        int count = 0;
        HashMap<Character, Set<Character>> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        int[] degree = new int[26];
        //查看一共出现了几个字母， 并且degree[] 出现的为1 未出现的为0
        for(String word : words){
            for (Character ch : word.toCharArray()){
                if(degree[ch - 'a'] == 0){
                    degree[ch - 'a'] = 1;
                    count++;
                }
            }
        }
        //建立图， 入度为一的为起点， 入度大于一的为被指向的节点
        for(int i = 0; i < words.length - 1; i++){
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++){
                if(cur[j] != next[j]){
                    if(!map.containsKey(cur[j])){
                        map.put(cur[j], new HashSet<>());
                    }
                    if(map.get(cur[j]).add(next[j])){
                        degree[next[j] - 'a']++;
                    }
                }
            }
        }
        //bfs
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < 26; i++){
            if(degree[i] == 1){
                queue.offer((char)(i + 'a'));
            }
        }
        while (!queue.isEmpty()){
            Character ch = queue.poll();
            res.append(ch);
            for (Character c: map.get(ch)){
                if(--degree[c - 'a'] == 1){
                    queue.offer(c);
                }
            }
        }
        //不相等说明出现了孤立的点
        if (res.length() != count) return "";
        return res.toString();
    }
}
