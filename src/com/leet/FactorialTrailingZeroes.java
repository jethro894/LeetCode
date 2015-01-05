package com.leet;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
        if(n < 0)
        	return -1;
        
        if(n == 0)
        	return 1;
        
        int count = 0;
        int cur = n;
        while(cur > 0){
        	cur /= 5;
        	count++;
        }
        
        return count;
    }
}
