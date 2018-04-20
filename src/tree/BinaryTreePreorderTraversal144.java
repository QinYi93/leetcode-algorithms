package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-06
 */
public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    public void preorder(TreeNode root, List<Integer> res){
        res.add(root.val);
        if (root.left != null)
            preorder(root.left, res);
        if (root.right != null)
            preorder(root.right, res);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;}
  }