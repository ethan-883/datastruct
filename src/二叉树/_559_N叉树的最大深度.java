package 二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class _559_N叉树的最大深度 {
	public int maxDepth(Node root) {
		int depth = 0;
		if (root == null) return depth;
		
		Deque<Node> queue = new LinkedList<>();
		Node node = root;
		queue.offer(node);
		int size;
		while (!queue.isEmpty()) {
			size = queue.size();			
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				for (Node child : node.children) {
					if (child != null) {
						queue.offer(child);
					}
				}				
			}
			depth++;
		}
		return depth;
	}
}
