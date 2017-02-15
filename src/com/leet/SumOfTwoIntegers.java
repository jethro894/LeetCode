package com.leet;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SumOfTwoIntegers().getSum(25, 663));
	}
	
	public int getSum(int a, int b) {
        if(a == 0){
            return b;
        }
        
        if(b == 0){
            return a;
        }
        
        int res = 0;
        boolean carry = false;
        for(int i = 0; i < 32; i++){
            int abit = (a & (1<<i));
            int bbit = (b & (1<<i));
            
            int plus = abit ^ bbit;
            
            if(carry){
                plus ^= (1<<i);
            }
            
            res |= plus;
            
            if(carry){
                if(abit == 0 && bbit == 0){
                    carry = false;
                }
            }else{
                if(abit != 0 && bbit != 0){
                    carry = true;
                }
            }
        }
        
        return res;
    }

}
