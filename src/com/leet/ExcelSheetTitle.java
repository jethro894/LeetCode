package com.leet;

public class ExcelSheetTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ExcelSheetTitle().convertToTitle(28));
	}
	
	public String convertToTitle(int n) {
        if(n < 1)
        	return "";

        StringBuilder sb = new StringBuilder();
        int cur = n;
        while(cur > 0){
        	cur--;
        	int residue = cur % 26;
        	sb.insert(0, numToChar(residue));
        	cur /= 26;
        }
        
        return sb.toString();
    }
	
	public char numToChar(int n){
		if(n < 0 || n > 26)
			return ' ';
		return (char)(n + 'A');
	}

}
