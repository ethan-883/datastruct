package 链表;

public class _19_删除链表的倒数第N个结点 {
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		if (slow.next != null) {
			slow.val = slow.next.val;
			slow.next = slow.next.next;
		} else {
			slow = null;
		}
		
		return head;
	}
}
