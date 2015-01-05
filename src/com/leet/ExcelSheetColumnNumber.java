package com.leet;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        if(s.length() == 0)
        	return -1;
        
        char[] ss = s.toCharArray();
        int result = 0;
        for(int i = ss.length - 1; i >= 0; i--){
        	char c = ss[i];
        	int no = c-'A';
        	if(no < 0 || no > 25)
        		return -1;
        	no++;
        	result += no * (int)Math.pow(26, ss.length-1-i);
        }
        
        return result;
    }
	
	public static void main(String[] args){
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("Z"));
	}
}
