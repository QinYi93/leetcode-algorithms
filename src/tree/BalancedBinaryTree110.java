package tree;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-03-19
 */
public class BalancedBinaryTree110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        left.right = right;
        isBalanced(root);
    }
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int ld = 0;
        int rd = 0;
        if(root.left == null) ld = 0;
        if(root.right == null) rd = 0;
        else{
            ld = helper(root.left);
            rd = helper(root.right);
        }
        return Math.abs(ld - rd) > 1 ? false : true ;
    }
    public static int helper(TreeNode root){
        if(root == null)
            return 1;
        return Math.max(helper(root.left) + 1, helper(root.right) + 1);
    }
}
