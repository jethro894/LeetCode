package com.leet;

public class LengthLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(lengthOfLastWord("Hwllo World"));
	}
	
	public static int lengthOfLastWord(String s) {
        if(s.length() == 0)
        	return 0;
        
        int length = 0;
        int i = s.length() - 1;
        while(i >= 0){
        	if(s.charAt(i) == " ".charAt(0))
        		if(length != 0)
        			return length;
        		else{
        			i--;
        			continue;
        		}
        			
        	length++;
        	i--;
        }
        return length;
    }

}
