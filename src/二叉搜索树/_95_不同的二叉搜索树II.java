package 二叉搜索树;

import java.util.ArrayList;
import java.util.List;

public class _95_不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        //base case
        if (low > high) {
            res.add(null);
            return res;
        }
        
        for (int i = low; i <= high; i++) {
            //构造左右子树
            List<TreeNode> leftTree = build(low, i - 1);
            List<TreeNode> rightTree = build(i + 1, high);
            
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
