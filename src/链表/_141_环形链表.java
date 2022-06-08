package 链表;

public class _141_环形链表 {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
        //NullPotinerException
		if (head == null || head.next == null) {
        	return false;
        }
		
		ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
        	if (fast.next == slow.next) {
        		return true;
        	}
        	
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        return false;
    }
}
