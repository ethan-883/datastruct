package 剑指offer;

public class _剑指Offer_18_删除链表的节点 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x; }
	}
	public ListNode deleteNode(ListNode head, int val) {
		//单指针
		ListNode temp = new ListNode(0);
		temp.next = head;
		head = temp;
		while (temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
				return head.next;
			}
			temp = temp.next;
		}
		return head.next;
		
		/*ListNode first = head;
		if (first != null) {
			if (first.val == val) {
				return first.next;
			} 
		} else {
			return null;
		}
		ListNode second = first.next;
		
		while (second != null) {
			second = first.next;
			if (second.val == val) {
				if (second.next != null) {
					first.next = second.next;
					second.next = null;
				} else {
					first.next = null;
				}
				break;
			}
			first = first.next;
		}
		return head;*/	
	}
}
