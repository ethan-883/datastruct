package 链表;

public class _83_删除排序链表中的重复元素 {
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
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head;
		
		/*if (temp == null) return null;
		
		while (temp.next != null) {
			if (temp.next.val == temp.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}*/
		
		while (temp != null && temp.next != null) {
			if (temp.next.val == temp.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		
		return head;
	}
}
