package com.leet;

public class RegexMatch {
	public static char star = "*".charAt(0);
	public static char dot = ".".charAt(0);
	
	public static boolean isMatch(String a, String b){
		int index_a, index_b;
				
		if(a.length() == 0 && b.length() == 0){
			return true;
		}else if(a.length() == 0 || b.length() == 0){
			return false;
		}
		
		index_a = 0;
		index_b = 0;
		
		if(a.charAt(0) == star)
			index_a++;
		if(b.charAt(0) == star)
			index_b++;
		
		while(index_a < a.length() && index_b < b.length()){
			
			char tempA = a.charAt(index_a);
			char tempB = b.charAt(index_b);
			
			//all or no dot
			if((tempA == dot || tempB == dot) && tempA != star && tempB != star){
				//match
				index_a++;
				index_b++;
				continue;
			}
			
			//all or no star
			if(tempA == star || tempB == star){
				//both are star
				if(tempA == star && tempB == star){
					//match
					index_a++;
					index_b++;
					continue;
				}
				//one is star
				if(tempA == star){
					if(matches(a.charAt(index_a-1), tempB)){
						index_b++;
						continue;
					}else{
						index_a++;
						continue;
					}
				}
				if(tempB == star){
					if(matches(b.charAt(index_b-1), tempA)){
						index_a++;
						continue;
					}else{
						index_b++;
						continue;
					}
				}
				continue;
			}
			
			if(index_a == a.length()-1 && index_b < b.length()-1){
				if(b.charAt(index_b+1) == star){
					index_b++;
					continue;
				}
				return false;	
			}
				
			if(index_b == b.length()-1 && index_a < a.length()-1){
				if(a.charAt(index_a+1) == star){
					index_a++;
					continue;
				}
				return false;
			}
				
			//normal
			if(matches(tempA, tempB)){
				//match
				index_a++;
				index_b++;
				continue;
			}else{
				if(a.charAt(index_a+1) == star){
					index_a++;
					continue;
				}
				if(b.charAt(index_b+1) == star){
					index_b++;
					continue;
				}	
				return false;
			}
			
		}
		return true;
	}
	
	public static boolean matches(char a, char b){
		if(a == b)
			return true;
		else if(a == dot || b == dot)
			return true;
		else
			return false;
	}
}
