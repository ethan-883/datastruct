package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class _剑指Offer_07_重建二叉树 {
	private Map<Integer, Integer> map;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int length = preorder.length;
		
		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			map.put(inorder[i], i);
		}
		
		return myBuildTree(preorder, inorder, 0, length-1, 0, length-1);
	}
	
	public TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
		if (preLeft > preRight || inLeft > inRight) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preLeft]);
		int pIndex = map.get(preorder[preLeft]);
		root.left = myBuildTree(preorder, inorder, preLeft + 1, preLeft + pIndex - inLeft, inLeft, pIndex - 1);
		root.right = myBuildTree(preorder, inorder, preLeft + pIndex - inLeft + 1, preRight, pIndex + 1, inRight);
		return root;
	}
	
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
