package com.leet;

public class ReverseInt {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(reverse(-100));
	}
	
	public static int reverse(int x) throws Exception{
        boolean sign;
        
        if(x >= 0)
            sign = true;
        else{
            sign = false;
            x = -x;
        }
            
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        String s = sb.reverse().toString();
        
        if(sign)
            return Integer.parseInt(s);
        else
            return -Integer.parseInt(s);
        
    }
}
