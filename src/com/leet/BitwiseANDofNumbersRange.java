package com.leet;

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(5,7));
	}
	
    public int rangeBitwiseAnd(int m, int n) {
        if(n < m)
        	return 0;
        else if(n == m)
        	return m&n;
        else{
        	int mask = Integer.MAX_VALUE;
        	for(int i = 0; i < 32; i++){
        		if((m & mask) == (n & mask)){
        			return m & mask;
        		}else{
        			mask = mask << 1;
        		}
        	}
            return mask;
        }
    }
}
