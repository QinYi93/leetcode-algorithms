package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class 层次遍历的变形
 * time O(n)
 * space O(n)
 * @author Yi Qin
 * @date 2018-05-08
 */
public class SerializeandDeserializeBinaryTree297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        //queue 后面用linkedlist来接住
        Queue<TreeNode> queue = new LinkedList<>();
        //当要动态的添加string时需要使用string builder
        StringBuilder res = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                res.append("null ");
                continue;
            }
            res.append(cur.val+" ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        //转成字符串的时候使用toString
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 1; i < str.length; i++){
            TreeNode cur = queue.poll();
            if(!str[i].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.left);
            }
            if(!str[++i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
