package com.leet;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack;
	Stack<Integer> min;
	
	public MinStack(){
	    stack = new Stack<Integer>();
	    min = new Stack<Integer>();
	}
	
	public void push(int x) {
        if(stack == null && min == null){
        	stack = new Stack<Integer>();
        	min = new Stack<Integer>();
        }
        
        if(stack.isEmpty() && min.isEmpty()){
        	stack.push(x);
        	min.push(x);
        }
        else{
        	stack.push(x);
        	int min_so_far = min.peek();
        	if(x <= min_so_far)
        		min.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
        	int top = stack.pop();
        	if(!min.isEmpty() && top == min.peek())
        		min.pop();
        }
        else{
        	min.clear();
        }
    }

    public int top() {
        if(!stack.isEmpty())
        	return stack.peek();
        else
        	return 0;
    }

    public int getMin() {
        if(!min.isEmpty())
        	return min.peek();
        else
        	return 0;
    }

}
