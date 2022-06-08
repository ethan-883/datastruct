package 二叉搜索树;

public class _700_二叉搜索树中的搜索 {
	public TreeNode searchBST(TreeNode root, int val) {
		//递归
		/*if (root == null) return null;
		
		if (val < root.val) {
			 return searchBST(root.left, val);
		} else if (val > root.val) {
			return searchBST(root.right, val);
		} else {
			return root;
		}*/
		//迭代
		while (root != null && val != root.val) {
			root = val < root.val ? root.left : root.right;
		}
		return root;
	}
}
