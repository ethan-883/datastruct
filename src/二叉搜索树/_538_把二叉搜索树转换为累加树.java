package 二叉搜索树;

public class _538_把二叉搜索树转换为累加树 {
	int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        //先右后左的递归中序遍历
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
        //迭代
        /*if (root == null) {
            return null;
        }
        TreeNode cur = root;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;*/
       
    }
}
