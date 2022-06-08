package 队列;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/implement-stack-using-queues/
public class _225_用队列实现栈 {
	class MyStack {
		Queue<Integer> q1;
		Queue<Integer> q2;
		
	    /** Initialize your data structure here. */
	    public MyStack() {
	    	q1 = new LinkedList<Integer>();
	    	q2 = new LinkedList<>();
	    }
	    
	    /** Push element x onto stack. */
	    //2个队列
	    public void push(int x) {
	    	q2.offer(x);
	    	while (!q1.isEmpty()) {
	    		q2.offer(q1.poll());
	    	}
	    	
	    	Queue<Integer> temp = new LinkedList<>();
	    	temp = q1;
	    	q1 = q2;
	    	q2 = temp;
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	    	return q1.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	return q1.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	    	return q1.isEmpty();
	    }
	}
}
