package 二叉树;

public class _116_填充每个节点的下一个右侧节点指针 {
	public Node connect(Node root) {
        //前序遍历
        //base case
        if (root == null) {
            return null;
        }
        
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != root.next.left) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
	//法二 层序遍历
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
}
