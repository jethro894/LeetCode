package com.leet;

public class NumberComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NumberComplement().findComplement(1));
	}

	public int findComplement(int num) {
        int firstOneIndex = -1;
        int mask = 0;
        
        int tester = Integer.MIN_VALUE;
        
        for(int i = 0; i < 32; i++){
            if(((num << i)&tester) == tester){
                firstOneIndex = i;
                break;
            }
        }
        
        for(int j = 0; j <firstOneIndex; j++){
            mask |= (tester >> j);
        }
        
        return ((~num) & (~mask));
    }
}
