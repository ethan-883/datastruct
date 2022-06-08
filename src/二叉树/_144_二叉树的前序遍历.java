package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class _144_二叉树的前序遍历 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
	     if (root == null) {
	         return res;
	     }
	     Deque<TreeNode> stack = new LinkedList<>();
	     stack.push(root);
	     while (!stack.isEmpty()) {
	         TreeNode temp = stack.poll();
	         res.add(temp.val);
	        
	         if (temp.right != null) {
	             stack.push(temp.right);
	         }
	         if (temp.left != null) {
	             stack.push(temp.left);
	         }
	         
	     }
	     return res;
	}

}
