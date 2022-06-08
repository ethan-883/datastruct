package 栈;

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//https://leetcode-cn.com/problems/implement-queue-using-stacks/
public class _232_用栈实现队列 {
	/** Initialize your data structure here. */
    private Stack<Integer> inStack = new Stack<>();
	private Stack<Integer> outStack = new Stack<>();
	
    public _232_用栈实现队列() {
    	
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if (outStack.isEmpty()) {
    		while (!inStack.isEmpty()) {
    			outStack.push(inStack.pop());
    		}
    	}
    	return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if (outStack.isEmpty()) {
    		while (!inStack.isEmpty()) {
    			outStack.push(inStack.pop());
    		}
    	}
    	return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return inStack.isEmpty() && outStack.isEmpty();
    }
}

