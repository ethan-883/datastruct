package 二叉树;
//https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/

public class _226_翻转二叉树 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
    }
}
