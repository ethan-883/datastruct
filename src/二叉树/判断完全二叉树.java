package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

public class 判断完全二叉树 {
	//层序遍历
	public static void main(String[] args) {
		
	}
    public static boolean judge(Node root) {
        boolean isLeaf = false;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if ((isLeaf && (node.left != null || node.right != null))
                || (node.left == null && node.right != null)) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                isLeaf = true;
            }
        }
        return true;
    }
    class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }
}
