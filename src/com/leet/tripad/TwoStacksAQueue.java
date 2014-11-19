package com.leet.tripad;

import java.util.Stack;

public class TwoStacksAQueue {
	Stack<Integer> in, out;
	
	public TwoStacksAQueue(){
		in = new Stack<Integer>();
		out = new Stack<Integer>();
	}
	public void queue(int val){
		in.push(val);
	}
	
	public int dequeue(){
		if(out.isEmpty())
			while(!in.isEmpty())
				out.push(in.pop());
		
		if(!out.isEmpty())
			return out.pop();
		else
			return -1;
	}
}
