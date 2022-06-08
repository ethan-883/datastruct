package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/die-dai-fa-by-jason-2/

//使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
//如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
//如果遇到的节点为灰色，则将节点的值输出。

public class _94_二叉树的中序遍历 {
	public List<Integer> inorderTraversal(TreeNode root) {
		//颜色法
		/*Deque<Object> stack = new LinkedList<>();
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null) return res;
		
		stack.push(root);
		while (!stack.isEmpty()) {
			Object pop = stack.pop();
			if (pop instanceof Integer) {
				res.add((Integer) pop);
			} else {
				TreeNode treeNode = (TreeNode) pop;
				if (treeNode.right != null) {
					stack.push(treeNode.right);
				}
				stack.push(new Integer(treeNode.val));
				if (treeNode.left != null) {
					stack.push(treeNode.left);
				}
			}
		}
		return res;*/
		
		/*List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) return res;
		TreeNode temp = root;
		while (stack.size() > 0 || temp != null) {
			if (temp != null) {
				stack.add(temp);
				temp = temp.left;
			} else {
				TreeNode temp2 = stack.pop();
				res.add(temp2.val);
				temp = temp2.right;
			}
		}
		return res;*/
		//普通迭代法
		/*List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return res;
		
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
		 	while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode temp = stack.pop();
			res.add(temp.val);
			cur = temp.right;
			//或者
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode temp = stack.pop();
				res.add(temp.val);
				cur = temp.right;
			}
			
		}
		return res;*/
		//Morris
		List<Integer> res = new ArrayList<>();
		TreeNode pre = null;
		while (root != null) {
			if (root.left != null) {
				pre = root.left;
				while (pre.right != null) {
					pre = pre.right;
				}
				pre.right = root;
				TreeNode temp = root;
				root = root.left;
				temp.left = null;
			} else {
				res.add(root.val);
				root = root.right;
				
			}
		}
		return res;
		
		
	}
}
