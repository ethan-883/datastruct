package 二叉搜索树;

public class _450_删除二叉搜索树中的节点 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;
		
		if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.right != null) {
				root.val = successor(root);
				root.right = deleteNode(root.right, root.val);
			} else {
				root.val = predecessor(root);
				root.left = deleteNode(root.left, root.val);
			}
		}
		return root;
	}
	//中序遍历的前驱节点
	//node.left != null
	public int predecessor(TreeNode node) {
		node = node.left;
		
		while (node.right != null) {
			node = node.right;
		}
		return node.val;
	}
	//后继节点
	public int successor(TreeNode node) {
		node = node.right;
		
		while (node.left != null) {
			node = node.left;
		}
		return node.val;
	}	
}
