package 二叉树;
//https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

public class _106_从中序与后序遍历序列构造二叉树 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int length = inorder.length;
		TreeNode tree = null;
		tree.val = postorder[length - 1];
		
		
		
		
		return tree;
	}
}
