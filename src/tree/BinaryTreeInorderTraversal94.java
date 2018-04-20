package tree;

import java.util.*;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-08
 */
public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        TreeNode left3 = new TreeNode(6);
        root.right = right;
        root.left = left;
        left.left = left1;
        left.right = right2;
        right.left = left3;
        List<Integer> output = inorderTraversal(root);
        for(Integer i : output)
            System.out.println(i);
        Queue<Integer> q = new PriorityQueue<>();
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
