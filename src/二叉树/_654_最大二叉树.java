package 二叉树;

public class _654_最大二叉树 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        TreeNode root = recurse(nums, 0, nums.length - 1);
        return root;
    }
    private TreeNode recurse(int[] nums, int left, int right) {
        //base case
        if (left > right) {
            return null;
        }

        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = recurse(nums, left, maxIndex - 1);
        root.right = recurse(nums, maxIndex + 1, right);
        return root;
    }
}
