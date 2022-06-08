package 二叉搜索树;

public class _98_验证二叉搜索树 {
	public boolean isValidBST(TreeNode root) {
        //中序遍历为数组，判断是否递增

        //递归
        return isValidBST(root, null, null);
    }
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
