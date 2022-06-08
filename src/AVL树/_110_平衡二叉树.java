package AVL树;

public class _110_平衡二叉树 {
	//自顶向下的递归,height重复调用
	/*public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		return (isBalanced(root.left) && isBalanced(root.right)
				&& (Math.abs(height(root.left) - height(root.right)) < 2));
	}
	
	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}*/
	//自底向上的递归，类似后序遍历
	//如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1−1。
	//如果存在一棵子树不平衡，则整个二叉树一定不平衡。
	public boolean isBalanced(TreeNode root) {
		return height(root) >= 0;
	}
	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = height(root.right);
		if (leftHeight == -1 || rightHeight == -1 || (Math.abs(leftHeight - rightHeight) > 1)) {
			return -1;
		} else {
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}
}
