package 链表;

public class _25_K个一组翻转链表 {
	public ListNode reverseKGroup(ListNode head, int k) {
        //base case
        if (head == null) {
            return null;
        }
        ListNode a, b;
        a = b = head;

        for (int i = 0; i < k; i++) {
           if (b == null) {
               return head;
           }
           b = b.next;
        }

        ListNode newHead = reverse(a, k);
        head.next = reverseKGroup(b, k);

        return newHead;
    }
    //反转前N个
    ListNode successor = null;
    private ListNode reverse(ListNode head, int n) {
        if (head == null || n == 1) {
            return head;
        }

        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverse(head.next, n-1);
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
