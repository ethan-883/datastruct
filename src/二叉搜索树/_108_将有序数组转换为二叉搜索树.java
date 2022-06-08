package 二叉搜索树;

public class _108_将有序数组转换为二叉搜索树 {
	public TreeNode sortedArrayToBST(int[] nums) {
		return dfs(nums, 0, nums.length - 1);
	}
	
	private TreeNode dfs(int[] nums, int low, int high) {
		if (low > high) {
			return null;
		}
		
		int mid = low + (high - low) /2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = dfs(nums, low, mid - 1);
		root.right = dfs(nums, mid + 1, high);
		return root;
	}
}
