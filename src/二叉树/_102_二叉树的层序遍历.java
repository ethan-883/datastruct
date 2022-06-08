package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_二叉树的层序遍历 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new LinkedList<>();
		if (root == null) return list;
		
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode node;
		int size;
		queue.add(root);
		while (!queue.isEmpty()) {
			size = queue.size();
			List<Integer> tempList = new LinkedList<>();
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
			list.add(tempList);
		}		
		return list;
	}
}
