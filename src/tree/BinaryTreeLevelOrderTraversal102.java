package tree;

import java.util.*;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-09
 */
public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left1 = new TreeNode(15);
        TreeNode right1 = new TreeNode(7);
        root.right = right;
        root.left = left;
        right.left = left1;
        right.right = right1;
        List<List<Integer>> output = levelOrder(root);
        for (List<Integer> list : output) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        helper(res, queue);
        return res;
    }

    public static void helper(List<List<Integer>> res, Queue<TreeNode> queue) {
        if (queue.isEmpty()) return;
        List<Integer> list = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode root = queue.poll();
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            list.add(root.val);
        }
        res.add(list);
        helper(res, queue);
    }
}
