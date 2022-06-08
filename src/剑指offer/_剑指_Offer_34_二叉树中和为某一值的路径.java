package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_34_二叉树中和为某一值的路径 {
	List<List<Integer>> res;
    Deque<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        //dfs
        res = new LinkedList<List<Integer>>();
        path = new LinkedList<Integer>();
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        path.offerLast(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            res.add(new LinkedList<Integer>(path));
        }
        dfs(node.left, target);
        dfs(node.right, target);
        path.pollLast();
    }
}
