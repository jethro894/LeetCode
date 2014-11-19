package com.leet.tripad;

public class RotateArray {
	
	public void rotateRight(int[] array, int n){
		if(array.length == 0 || n == 0)
			return;
		
		n %= array.length;
		
		int temp, temp2;
		for(int i = 0; i <= n - 1; i++){
			temp = array[i];
			int j = i;
			while(j + n <= array.length - 1){
				temp2 = array[j+n];
				array[j+n] = temp;
				temp = temp2;
				j += n;
			}
			array[(j+n)%array.length] = temp;
		}
	}
	
	public void rotateLeft(int[] array, int n){
		if(array.length == 0 || n == 0)
			return;
		
		n %= array.length;
		
		int temp, temp2;
		for(int i = array.length-1; i > array.length-1-n; i--){
			temp = array[i];
			int j = i;
			while(j - n >= 0){
				temp2 = array[j-n];
				array[j-n] = temp;
				temp = temp2;
				j -= n;
			}
			array[(j-n)+array.length] = temp;
		}
	}

}
