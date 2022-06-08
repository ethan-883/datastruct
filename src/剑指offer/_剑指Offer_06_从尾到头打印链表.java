package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;

public class _剑指Offer_06_从尾到头打印链表 {
	public int[] reversePrint(ListNode head) {
		//用栈
		Deque<ListNode> stack = new LinkedList<>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		
		int[] arr = new int[stack.size()];
		int i = 0;
		while(!stack.isEmpty()) {
			arr[i++] = stack.pop().val; 
		}
		return arr;
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x; }
	}
}
