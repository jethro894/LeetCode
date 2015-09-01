package com.leet;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseBits().reverseBits(43261596));
	}
	
	public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
        	result = result << 1;
        	if((n&1) == 0){
        		//last digit 0
        		result = result | 0;
        	}else{
        		//last digit 1
        		result = result | 1;
        	}
        	n = n >> 1;
        }
        return result;
    }

}
