package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-12
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        TreeNode left1 = new TreeNode(13);
        TreeNode right1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(11);
        TreeNode left3 = new TreeNode(7);
        TreeNode right3 = new TreeNode(2);
        TreeNode left4 = new TreeNode(5);
        TreeNode right4 = new TreeNode(1);
        root.right = right;
        root.left = left;
        right.left = left1;
        right.right = right1;
        left.left = left2;
        left2.left = left3;
        left2.right = right3;
        right1.left = left4;
        right1.right = right4;
        pathSum(root, 22);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, 0, res, sum, new ArrayList<>());
        return res;
    }
    public static void helper(TreeNode root, int count, List<List<Integer>> res, int sum, List<Integer> list){
        if(root.left == null && root.right == null){
            count += root.val;
            if(count == sum){
                list.add(root.val);
                res.add(list);
            }
            return;
        }
        list.add(root.val);
        if(root.left != null){
            helper(root.left, count + root.val, res, sum, list);
        }
        if(root.right != null){
            helper(root.right, count + root.val, res, sum, list);
        }
    }
}
