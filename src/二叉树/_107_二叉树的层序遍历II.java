package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class _107_二叉树的层序遍历II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new LinkedList<>();
		if (root == null) return list;
		
		Stack<List<Integer>> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int size;
		TreeNode node;
		/*while (!queue.isEmpty()) {
			size = queue.size();			
			List<Integer> tempList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				tempList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			stack.push(tempList);
		}
		
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}*/
		//不需要栈保存，每次添加到列表对头
		while (!queue.isEmpty()) {
			size = queue.size();			
			List<Integer> tempList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				tempList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			list.add(0, tempList);
		}
			
		return list;
    }
}
