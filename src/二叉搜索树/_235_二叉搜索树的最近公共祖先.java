package 二叉搜索树;

public class _235_二叉搜索树的最近公共祖先 {
	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (contains(root, p, q)) {
			if (contains(root.left, p, q)) {
				root = root.left;
			}
			if (contains(root.right, p, q)) {
				root = root.right;
			}
			break;
		}
		return root;
	}
	
	//contain return true
	public boolean contains(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return false;
		
		boolean flag1 = false, flag2 = false;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if (node.val == p.val) {
				flag1 = true;
			} 
			if (node.val == q.val) {
				flag2 = true;
			}
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return (flag1 && flag2);
	}*/
	//2次遍历
	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pathP = getPath(root, p);
		List<TreeNode> pathQ = getPath(root, q);
		TreeNode ancestor = null;
		for (int i = 0; i < pathP.size() && i < pathQ.size(); ++i) {
			if (pathP.get(i) == pathQ.get(i)) {
				ancestor = pathP.get(i);
			} else {
				break;
			}	
		}
		return ancestor;
	}
	public List<TreeNode> getPath(TreeNode root, TreeNode target) {
		List<TreeNode> path = new ArrayList<TreeNode>();
		TreeNode node = root;
		while (node != target) {
			path.add(node);
			if (target.val < node.val) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		path.add(node);
		return path;
	}*/
	//1次遍历
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ancestor = root;
		while (true) {
			if (p.val < ancestor.val && q.val < ancestor.val) {
				ancestor = ancestor.left;
			} else if (p.val > ancestor.val && q.val > ancestor.val) {
				ancestor = ancestor.right;
			} else {
				break;
			}
		}
		return ancestor;
	}
}
