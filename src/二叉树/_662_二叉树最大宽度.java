package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

//这个问题中的主要想法是给每个节点一个 position 值，
//如果我们走向左子树，那么 position -> position * 2，
//如果我们走向右子树，那么 position -> positon * 2 + 1。
//当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1。

public class _662_二叉树最大宽度 {
	public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            //一个结点一个结点判断
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                //每个结点都要判断
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }
	class AnnotatedNode {
	    TreeNode node;
	    int depth, pos;
	    AnnotatedNode(TreeNode n, int d, int p) {
	        node = n;
	        depth = d;
	        pos = p;
	    }
	}
}
