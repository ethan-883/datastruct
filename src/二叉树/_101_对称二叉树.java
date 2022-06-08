package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _101_对称二叉树 {
	/*public boolean isSymmetric(TreeNode root) {
		//迭代
		return check(root, root);
	}
	
	public boolean check(TreeNode u, TreeNode v) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(u);
		q.offer(v);
		while (!q.isEmpty()) {
			u = q.poll();
			v = q.poll();
			if (u == null && v == null) {
				continue;
			}
			
			if ((u == null || v == null) || (u.val != v.val)) {
				return false;
			}
			
			q.offer(u.left);
			q.offer(v.right);
			
			q.offer(u.right);
			q.offer(v.left);
		}
		return true;
	}*/
	//递归
	/*public boolean isSymmetric(TreeNode root) {
		return check(root, root);
	}
	public boolean check(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		
		if (p == null || q== null) {
			return false;
		}
		
		return (p.val == q.val) && check(p.left, p.right) && check(q.left, q.right);
	
	}*/
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);
		while (queue.size() > 0) {
			TreeNode left = queue.remove();
			TreeNode right = queue.remove();
			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null) {
				return false;
			}
			if (left.val != right.val) {
				return false;
			}
			//每一层的最左边和最右边
			queue.add(left.left);
			queue.add(right.right);
			
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;
	}
	
	
}
