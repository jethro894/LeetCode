package com.leet;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args){
		new HappyNumber().isHappy(19);
	}
	
    public boolean isHappy(int n) {
        Set<Integer> history = new HashSet<Integer>();
        while(n > 0){
        	if(history.contains(n))
        		return false;
        	else{
        		history.add(n);
        		n = sumDigitSquares(n);
        		if(n == 1)
        			return true;
        	}
        }
        return false;
    }

    private int sumDigitSquares(int n){
    	int sum = 0;
    	while(n > 0){
    		int mod = n%10;
    		sum += (mod*mod);
    		n /= 10;
    	}
    	return sum;
    }
}
