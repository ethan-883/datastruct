package 二叉树;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _1110_删点成林 {
	List<TreeNode> forest;
    HashSet<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new LinkedList<>();
        set = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        root = helper(root);
        if (root != null) {
            forest.add(root);
        }
        return forest;
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        if (set.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            if (root.right != null) {
                forest.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
