package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class _剑指Offer_09_用两个栈实现队列 {
	class CQueue {
		private Deque<Integer> appendStack = new ArrayDeque<>();
    	private Deque<Integer> deleteStack = new ArrayDeque<>();
		
	    public CQueue() {
	    	
	    }
	    
	    //没有必要用while，两个stack可以都有值
	    public void appendTail(int value) {
	    	/*while (!deleteStack.isEmpty()) {
	    		appendStack.push(deleteStack.pop());
	    	}*/
	    	appendStack.push(value);
	    }
	    
	    public int deleteHead() {
	    	/*while (!appendStack.isEmpty()) {
	    		deleteStack.push(appendStack.pop());
	    	}
	    	if (deleteStack.isEmpty()) {
	    		return -1;
	    	} else {
	    		return deleteStack.pop();
	    	}*/
	    	if (deleteStack.isEmpty()) {
	    		while (!appendStack.isEmpty()) {
	    			deleteStack.push(appendStack.pop());
	    		}
	    	}
	    	if (deleteStack.isEmpty()) {
	    		return -1;
	    	} else {
	    		return deleteStack.pop();
	    	}
	    }
	    
	}
}
