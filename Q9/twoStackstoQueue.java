
/*
 * 用两个栈实现一个队列。分别完成队列的push与pop操作。
 */

import java.util.Stack;

/*
 * 解法：stack1负责插入新元素；stack2负责转换工作。
 * 代码虽然没有几行，但是真正面试的时候有可能会因为api不熟悉而出现差错。
 */
public class twoStackstoQueue {
	public class Solution {
	    Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    
	    public void push(int node) {
	        stack1.push(node);
	    }
	    
	    public int pop() {
	    	if(!stack2.isEmpty())
	            return stack2.pop();
	        while(!stack1.isEmpty()){
	            stack2.push(stack1.pop());
	        }
	        return stack2.pop();
	    }
	}
}
