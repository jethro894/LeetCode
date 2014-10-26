package com.leet;

public class SortColors {
	
	public static int[] A = {0,1,2,2,2,2,1,0,2,2,1,0,0,0,1,2,2,2,1,0};
	
	public static void main(String[] args){
		sortColors(A);
	}
	
	public static void sortColors(int[] A) {
		int red = 0;
		int white = 0;
		int blue = 0;
		
		for(int i : A){
			if(i == 0)
				red++;
			else if(i == 1)
				white++;
			else
				blue++;
		}
		
		System.out.println("red:" + red + " white: " + white + " blue: " + blue);
		int j = 0;
		while(red>0){
			A[j] = 0;
			red--;
			j++;
		}
		while(white>0){
			A[j] = 1;
			white--;
			j++;
		}
		while(blue>0){
			A[j] = 2;
			blue--;
			j++;
		}
    }
	
}
