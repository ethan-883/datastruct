package 二叉树;

public class _222_完全二叉树的节点个数 {
	public int countNodes(TreeNode root) {
        //递归中判断子树是否为满二叉树
        if (root == null) {
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int hleft = 0;
        int hright = 0;
        while (left != null) {
            left = left.left;
            hleft++;
        }
        while (right != null) {
            right = right.right;
            hright++;
        }
        if (hleft == hright) {
            return (int) Math.pow(2, hleft) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);

    }
}
