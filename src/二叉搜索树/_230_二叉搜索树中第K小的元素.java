package 二叉搜索树;

public class _230_二叉搜索树中第K小的元素 {
	int rank = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }      
        traverse(root.right, k);
    }
}
