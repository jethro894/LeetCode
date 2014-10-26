package com.leet;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
	static List<String> result = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String s: generateParenthesis(5)){
			System.out.println(s);
		}
		
	}

	public static List<String> generateParenthesis(int n) {
		result.clear();
        result.add("(");
        expand(result, 0, 1, 0, n);
        List<String> refined = new ArrayList<String>();
        for(String s : result){
        	if(s.length() == 2*n)
        		refined.add(s);
        }
        return refined;
    }
	
	public static void expand(List<String> result, int index, int starts, int ends, int n){
		StringBuilder sb = new StringBuilder(result.get(index));
		//System.out.println("start: "+starts + " ends: " + ends);
			if(starts == n && ends == n){
				//base case
				return;
			}
			
			else if(starts == n){
				//must end
				sb.append(")");
				result.set(index, sb.toString());
				expand(result, index, starts, ends+1, n);	
			}
			
			else if(starts == ends){
				//must start ( 
				sb.append("(");
				result.set(index, sb.toString());
				expand(result, index, starts+1, ends, n);	
			}
			else if(starts < ends){
				//error
				System.out.print("error");
				return;
			}
			
			else{
				//2 choices
				//start one:
				StringBuilder startNew = new StringBuilder(sb.toString());
				startNew.append("(");
				result.add(startNew.toString());
				expand(result, result.size()-1, starts+1, ends, n);
				
				//end one:
				StringBuilder endOld = new StringBuilder(sb.toString());
				endOld.append(")");
				result.add(endOld.toString());
				expand(result, result.size()-1, starts, ends+1, n);
				
			}
			
	}

}
