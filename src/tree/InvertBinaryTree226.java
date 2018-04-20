package tree;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-10
 */
public class InvertBinaryTree226 {
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
        invertTree(root);
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        helper(root.left, root.right);
        return root;
    }
    public static void helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return;
        if(left == null){
            left = right;
            right = null;
            helper(left.left, left.right);
        }
        if(right == null){
            right = left;
            left = null;
            helper(right.left, right.right);
        }else{
            TreeNode temp = left;
            left = right;
            right = temp;
            helper(left.left, left.right);
            helper(right.left, right.right);
        }
    }
}
