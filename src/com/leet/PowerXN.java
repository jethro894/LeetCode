package com.leet;

public class PowerXN {

	public double pow(double x, int n) {
		if(n == 0)
        	return 1;
        
        int absn = Math.abs(n);
        if(absn == 1)
        	return (n > 0) ? x : 1/x;
        
        double result =(absn % 2 == 0)? pow(x*x, absn/2) : pow(x*x, absn/2)*x;
        return (n > 0) ? result : 1/result;
    }
	
	public static void main(String[] args){
		System.out.println(new PowerXN().pow(1.0000, Integer.MAX_VALUE));
		//System.out.println(Math.pow(8.84372, -3));
	}
}
