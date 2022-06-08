package 剑指offer;

public class _剑指Offer_22_链表中倒数第k个节点 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < k; i++) {
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
