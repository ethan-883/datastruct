package 二叉搜索树;

import java.util.LinkedList;
import java.util.Queue;

public class _938_二叉搜索树的范围和 {
	/*int sum = 0;
	public int rangeSumBST(TreeNode root, int low, int high) {	
		if (root == null) return sum;
		
		if (root.val >= low && root.val <= high) {
			sum += root.val;
		}
	
		rangeSumBST(root.left, low, high);
		rangeSumBST(root.right, low, high);
		return sum;
	}*/
	//dfs
	/*public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) return 0;
		
		if (root.val > high) {
			return rangeSumBST(root.left, low, high);
		}
		
		if (root.val < low) {
			return rangeSumBST(root.right, low, high);
		}
		
		return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
	}*/
	//广度优先搜索
	public int rangeSumBST(TreeNode root, int low, int high) {
		int sum = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) { 
			TreeNode node = q.poll();
			if (node == null) {
				continue;
			}
			if (node.val > high) {
				q.offer(node.left);
			}
			else if (node.val < low) {
				q.offer(node.right);
			} else {
				sum += node.val;
				q.offer(node.left);
				q.offer(node.right);
			}
		}
		return sum;
	}
}
