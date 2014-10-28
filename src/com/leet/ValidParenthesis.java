package com.leet;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("([)]"));
	}

	public static boolean isValid(String s) {
        if(s.length() == 0)
        	return true;
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == "(".charAt(0))
        		stack.push(s.charAt(i));
        	else if(s.charAt(i) == "[".charAt(0))
        		stack.push(s.charAt(i));
        	else if(s.charAt(i) == "{".charAt(0))
        		stack.push(s.charAt(i));
        	
        	else if(s.charAt(i) == ")".charAt(0)){
        		if(stack.isEmpty() || stack.pop() != "(".charAt(0))
        			return false;
        		continue;
        	}
        	else if(s.charAt(i) == "]".charAt(0)){
        		if(stack.isEmpty() || stack.pop() != "[".charAt(0))
        			return false;
        		continue;
        	}
        	else if(s.charAt(i) == "}".charAt(0)){
        		if(stack.isEmpty() || stack.pop() != "{".charAt(0))
        			return false;
        		continue;
        	}
        	else 
        		return false;
        }
        if(!stack.isEmpty())
        	return false;
        return true;
    }
}
