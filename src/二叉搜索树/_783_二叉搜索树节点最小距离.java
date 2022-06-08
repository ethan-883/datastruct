package 二叉搜索树;

public class _783_二叉搜索树节点最小距离 {
	int pre;
	int ans;
	public int minDiffInBST(TreeNode root) {
		//中序遍历
		//相邻节点的最小距离
		/*int minDiff = 100;
		
		if (root.left != null) {			
			if ((root.val - root.left.val) < minDiff) {
				minDiff = root.val - root.left.val;
			}
			minDiff = Math.min(minDiff, minDiffInBST(root.left));
		}
		if (root.right != null) {
			if ((root.right.val - root.val) < minDiff) {
				minDiff = root.right.val - root.val;
			}
			minDiff = Math.min(minDiff, minDiffInBST(root.right));
		}
		
		return minDiff;*/
		
		ans = Integer.MAX_VALUE;
		pre = -1;
		dfs(root);
		return ans;	
	}
	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if (pre == -1) {
			pre = root.val;
		} else {
			ans = Math.min(ans, root.val - pre);
			pre = root.val;
		}
		dfs(root.right);
	}
}
