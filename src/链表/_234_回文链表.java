package 链表;

import java.util.ArrayList;
import java.util.List;

public class _234_回文链表 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) 
		{ val = x; }
	}
	
	public boolean isPalindrome(ListNode head) {
		// 将链表的值复制到数组中
		List<Integer> vals = new ArrayList<Integer>();
		
		ListNode currentNode = head;
		while (currentNode != null) {
			vals.add(currentNode.val);
			currentNode = currentNode.next;
		}
		
		int front = 0;
		int back = vals.size() - 1;
		while (front < back) {
			if (!vals.get(front).equals(vals.get(back))) {
				return false;
			}
			front++;
			back--;
		}
		return true;
	}
	
	
}
