package 剑指offer;

public class _剑指_Offer_36_二叉搜索树与双向链表 {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);

        //头尾指针相互指向
        pre.right = head;
        head.left = pre;

        return head;
    }
    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);

        //pre在双向链表中位于cur左侧,是上次迭代的cur,pre==null时cur为head
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }

        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}

