package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class _剑指Offer_24_反转链表 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		/*ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;*/
		//代码一样，每次把head的next从指向右改为指向左
		/*if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;*/
		
		//栈
		if (head == null || head.next == null) {
			return head;
		}
		
		Stack<ListNode> stack = new Stack<>();
		
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		
		ListNode newHead = stack.pop();
		ListNode cur = newHead;
		
		while (!stack.isEmpty()) {
			cur.next = stack.pop();
			cur = cur.next;
		}
		//不处理的话，最后的2个节点成了环
		cur.next = null;
		return newHead;
	}
}
