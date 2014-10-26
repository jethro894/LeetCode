package com.leet;

public class RomanToInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(romanToInt("DCCCXC"));
	}

	public static int romanToInt(String s) {
		if(!s.matches("^[MDCLXVI]+$"))
			return 0;
        
        int plus = 0;
        int minus = 0;
        for(int i = 0; i < s.length()-1; i++){
        	if(toInt(s.substring(i, i+1)) < toInt(s.substring(i+1, i+2))){
        		minus += toInt(s.substring(i, i+1));
        	}
        	else{
        		plus += toInt(s.substring(i, i+1));
        	}
        }
        
        plus += toInt(s.substring(s.length()-1, s.length()));
        
        return plus-minus;
    }
	
	public static boolean smallerThan(String s1, String s2){
		String charset = "MDCLXVI";
		int s1Index = charset.indexOf(s1);
		int s2Index = charset.indexOf(s2);
		
		if(s1Index > s2Index)
			return true;
		return false;
	}
	
	public static int toInt(String s){
		if(s.equals("M")){ return 1000;}
		if(s.equals("D")){ return 500;}
		if(s.equals("C")){ return 100;}
		if(s.equals("L")){ return 50;}
		if(s.equals("X")){ return 10;}
		if(s.equals("V")){ return 5;}
		if(s.equals("I")){ return 1;}
		return -1;
	}
}
