package 二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class _104_二叉树的最大深度 {
	public int maxDepth(TreeNode root) {
		//不能用stack，层序遍历FIFO
		int deep = 0;
		if (root == null) return deep;
		
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int size;
		TreeNode node;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			deep++;
		}
		return deep;
    }
}
