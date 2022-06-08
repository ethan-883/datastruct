package 二叉树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class _145_二叉树的后序遍历 {
	//递归
	 /*public List<Integer> postorderTraversal(TreeNode root) {
		 List<Integer> res = new ArrayList<>();
		 postorder(root, res);
		 return res;
	 }
	 public void postorder(TreeNode root, List<Integer> res) {
		 if (root == null) return;
		 
		 postorder(root.left, res);
		 postorder(root.right, res);
		 res.add(root.val);
	 }*/
	//迭代
	/*public List<Integer> postorderTraversal (TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			//root.right == prev?
			if (root.right == null || root.right == prev) {
				res.add(root.val);
				prev = root;
				root = null;			
			} else {
				stack.push(root);
				root = root.right;				
			}
		}
		return res;
	}*/
	/*public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		Set<TreeNode> seen = new HashSet<>();
		while (root != null || !s.isEmpty()) {
			if (root == null && seen.contains(s.peek())) {
				ans.add(s.pop().val);
			} else if (root == null){
				seen.add(s.peek());
				root = s.peek().right;
			} else {
				s.push(root);
				root = root.left;
			}
		}
		return ans;
	}*/
}
