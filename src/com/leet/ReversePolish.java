package com.leet;

import java.util.EmptyStackException;
import java.util.Stack;

public class ReversePolish {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(A));
	}
	
	public static int evalRPN(String[] tokens) {
        if(tokens.length == 0)
        	return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < tokens.length; i++){
        	System.out.println("Evaluating: " + tokens[i]);
        	if(isInteger(tokens[i])){
        		stack.push(Integer.parseInt(tokens[i]));
        	}else{
        		int token2 = stack.pop();
        		int token1 = stack.pop();
        		
        		if(tokens[i].equals("+")){
        			stack.push(token1+token2);
        		}
        		if(tokens[i].equals("-")){
        			stack.push(token1-token2);
        		}
        		if(tokens[i].equals("*")){
        			stack.push(token1*token2);
        		}
        		if(tokens[i].equals("/")){
        			stack.push(token1/token2);
        		}
        	}
        }
		return stack.pop();
    }
	
	public static boolean isInteger(String s){
		try{
			Integer.parseInt(s);
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
