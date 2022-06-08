package 二叉树;
//https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
//左子节点的最右节点指向右子节点，不用担心分支，分支后面会处理，因为cur遍历了每个节点
public class _114_二叉树展开为链表 {
	public void flatten(TreeNode root) {
		TreeNode cur = root;
		TreeNode predecessor;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode next = cur.left;
				predecessor = next;
				while (predecessor.right != null) {
					predecessor = predecessor.right;					
				}
				predecessor.right = cur.right;
				cur.left = null;
				cur.right = next;
			}
			cur = cur.right;
		}
	}
}
