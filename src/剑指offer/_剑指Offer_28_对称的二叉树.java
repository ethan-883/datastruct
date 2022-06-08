package 剑指offer;

public class _剑指Offer_28_对称的二叉树 {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode (int x) {
    		val = x;
    	}
    }
}
