package 二叉树;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class _105_从前序与中序遍历序列构造二叉树 {
	//recursive
	/*public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLen = preorder.length;
		int inLen = inorder.length;
		
		if (preLen != inLen) return null;
		
		Map<Integer, Integer> map = new HashMap<>(preLen);
		for (int i = 0; i < inLen; i++) {
			map.put(inorder[i], i);
		}
		return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

	private TreeNode buildTree(int[] preorder, int preLeft, int preRight, 
			Map<Integer, Integer> map, int inLeft, int inRight) {
		if (preLeft > preRight || inLeft > inRight) return null;
		
		TreeNode root = new TreeNode(preorder[preLeft]);
		int pIndex = map.get(preorder[preLeft]);
		
		root.left = buildTree(preorder, preLeft + 1, pIndex-inLeft+preLeft, map, inLeft, pIndex + 1);
		root.right = buildTree(preorder, pIndex-inLeft+preLeft+1, preRight, map, pIndex + 1, inRight);
		return root;
	}*/
	//迭代法
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[0]);
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		int inorderIndex = 0;
		for (int i = 1; i < preorder.length; i++) {
			int preorderVal = preorder[i];
			TreeNode node = stack.peek();
			if (node.val != inorder[inorderIndex]) {
				node.left = new TreeNode(preorderVal);
				stack.push(node.left);
			} else {
				while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
					node = stack.pop();
					inorderIndex++;
				}
				node.right = new TreeNode(preorderVal);
				stack.push(node.left);
			}
		}
		return root;
	}
	
}
