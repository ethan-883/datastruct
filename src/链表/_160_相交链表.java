package 链表;

//https://leetcode-cn.com/problems/intersection-of-two-linked-lists/

public class _160_相交链表 {
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
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//hashset
		/*Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;*/
        //˫ָ�������������
		//���ж�null
		if (headA == null || headB == null) {
			return null;
		}
		
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}
}
