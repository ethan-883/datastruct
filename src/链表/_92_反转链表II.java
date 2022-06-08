package 链表;

public class _92_反转链表II {
	public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        if (head.next != null) {
            head.next = reverseBetween(head.next, left-1, right-1);
        }
        
        return head;
    }
    //反转前n个
    ListNode successor = null;
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        
        ListNode last = reverseN(head.next, n-1);

        head.next.next = head;
        head.next = successor;
        return last;
    }
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode() {}
    	ListNode(int val) { this.val = val; }
    	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
