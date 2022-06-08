package 链表;

public class _203_移除链表元素 {
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
	
	public ListNode removeElements(ListNode head, int val) {

/*		if (head == null) {
			return head;
		}
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;*/
	
		//头节点前建一个哑节点
		//dummyHead.next = head;temp = dummyHead;return dummyHead.next;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode temp = dummyHead;
		while (temp.next != null) {
			if (temp.next.val == val) {
				//
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return dummyHead.next;
		
		//
		/*while (head != null && head.val == val) {
			head = head.next;
		} 
		if (head == null) {
			return null;
		}*/
	}
}
