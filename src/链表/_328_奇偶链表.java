package 链表;

public class _328_奇偶链表 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) 
		{ val = x; }
	}
	
	public ListNode oddEvenList(ListNode head) {
		if (head == null) return head;
		
		ListNode evenHead = head.next;
		ListNode odd = head;
		ListNode even = evenHead;
		
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		//奇的末尾连接偶的开头
		odd.next = evenHead;
		return head;
    }
}
