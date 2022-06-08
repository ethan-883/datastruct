package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _589_N叉树的前序遍历 {
	public List<Integer> preorder(Node root) {
		//迭代
		List<Integer> list = new LinkedList<>();
		if (root == null) return list;
		
		int size = 0;//子结点个数
		Node node = root;
		Node children;
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			node = stack.pop();
			list.add(node.val);
			
			size = node.children.size();
			//子节点从右往左放入栈顶
			//for循环结束后，栈顶为最左侧子节点
			for (int i = size - 1; i >= 0; i--) {
				children = node.children.get(i);
				if (children != null) {
					stack.add(children);
				}
			}			
		}	
		return list;		
	}
	//dfs迭代
	/*List<Integer> value;
	
	public void dfs(Node root) {
		value.add(root.val);
		for (Node child : root.children) {
			dfs(child);
		}
	}
	
	public List<Integer> preorder(Node root) {
		value = new ArrayList<>();
		if (root == null) return value;
		
		dfs(root);
		return value;
	}*/
	
}
