package google;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-04-26
 */
public class Question1 {
    public int LongestPathWithSameValue(int[] A, int[] E) {
        if(A== null || A.length == 0){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < E.length; i= i + 2){
            if(!map.containsKey(E[i])){
                map.put(E[i], new ArrayList<>());
                map.get(E[i]).add(E[i + 1]);
            }else{
                map.get(E[i]).add(E[i + 1]);
            }
            if(!map.containsKey(E[i + 1])){
                map.put(E[i + 1], new ArrayList<>());
                map.get(E[i + 1]).add(E[i]);
            }else{
                map.get(E[i + 1]).add(E[i]);
            }
        }
        int max = 0;
        boolean visited[] = new boolean[A.length];
        for(int i = 0; i < A.length; i++){
            int len = helper(A, map, i + 1, A[i], visited);
            max = Math.max(len, max);
        }
        return max;
    }

    private int helper(int[] A, Map<Integer, List<Integer>> map, int begin, int lable, boolean visited[]){
        int len = 0;
        List<Integer> list = map.get(begin);
        for(int i = 0; i < list.size(); i++){
            int node = list.get(i);
            if(visited[node - 1]){
                continue;
            }
            if(A[node - 1] == lable){
                visited[begin - 1] = true;
                len = Math.max(len, 1 + helper(A, map, node, lable, visited));
                visited[begin-1] = false;
            }
        }
        return len;
    }
    public int solution(int[] A, int[] E){
        if(A == null || A.length == 0 || E == null || E.length == 0) return 0;
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= A.length; i++){
            map.put(i, new Node(i, A[i - 1]));
        }
        Node root = map.get(1);
        for(int i = 1; i <= E.length; i+=2){
            if (map.get(E[i]).left == null){
                map.get(E[i]).left = map.get(E[i + 1]);
            }else map.get(E[i]).right = map.get(E[i + 1]);
        }
        return 0;

    }
}
class Node{
    int index;
    int label;
    Node left;
    Node right;
    public Node(int index, int label) {
        this.index = index;
        this.label = label;
    }
}
