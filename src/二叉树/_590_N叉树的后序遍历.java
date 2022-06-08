package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _590_N叉树的后序遍历 {
	//递归
	/*List<Integer> list = new LinkedList<>();
	public List<Integer> postorder(Node root) {
		if (root == null) return list;
		
		bps(root);
		
		return list;
	}
	public void bps(Node root) {		
		for (Node node : root.children) {
			bps(node);
		}
		list.add(root.val);
	}*/
	//迭代
	//需要标记子节点索引
	public List<Integer> postorder(Node root) {
	    List<Integer> value = new LinkedList<>();    
	    Deque<Node> stack = new LinkedList<>();
	    //child记录子节点遍历过的数量
	    Deque<Integer> child = new ArrayDeque<>();
	    Node cur = root;
	    //记录子节点位置
	    int next;
	    int size;
	    while (!stack.isEmpty() || cur != null) {
	    	size = cur.children.size();
	    	while (cur != null) {
	    		stack.push(cur);
	    		child.add(0);
	    		if (size > 0) {
	    			cur = cur.children.get(0);
	    		} else {
	    			cur = null;
	    		}
	    	}
	    	
	    	cur = stack.pop();
	    	next = child.pop();
	    	size = cur.children.size();
	    	if (size == 0 || next >= size) {
	    		value.add(cur.val);
	    		cur = null;
	    	} else {
	    		stack.push(cur);
	    		child.push(next + 1);
	    		if (next + 1 < size) {
	    			cur = cur.children.get(next + 1);
	    		} else {
	    			cur = null;
	    		}
	    	}
	    	
	    }
	    
	    
	    return value;
	}
}
