package 剑指offer;

import java.util.Stack;

public class _剑指Offer_30_包含min函数的栈 {
	
}
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    public void push(int x) {
        stackA.push(x);
        if (stackB.isEmpty() || x <= stackB.peek()) {
            stackB.push(x);
        }
    }
    
    public void pop() {
        if (stackA.pop().equals(stackB.peek())) {
            stackB.pop();
        }
    }
    
    public int top() {
        return stackA.peek();
    }
    
    public int min() {
        return stackB.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */