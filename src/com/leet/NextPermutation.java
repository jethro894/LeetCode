package com.leet;

import java.util.Arrays;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {};
		nextPermutation(a);
	}
	
	public static void nextPermutation(int[] num) {
        if(num == null || num.length == 0)
        	return;
        
        int start = -1;
    	int min_in_i = 99999;
    	int index_min_in_i = 0;
    	for(int i = num.length -1; i>0; i--){
    		int j = i-1;
    		if(num[i]> num[j]){
    			start = j;
    			
    			for(int k = start+1; k < num.length; k++){
    				if(num[k]>num[j] && num[k] < min_in_i){
    					min_in_i = num[k];
            			index_min_in_i = k;
    				}
    			}
    			break;
    		}
    	}
    	if(start == -1){
    		Arrays.sort(num);
    		for(int i : num){
            	System.out.print(i+",");
            }
    		return;
    	}
    	System.out.println("start: "+ start + " min_in_i: " + min_in_i + " index_min_in_i: " + index_min_in_i);
    	int temp = num[start];
		num[start] = min_in_i;
		num[index_min_in_i] = temp;
		for(int i : num){
        	System.out.print(i+",");
        }
		System.out.println();
		Arrays.sort(num, start+1, num.length);
        
        for(int i : num){
        	System.out.print(i+",");
        }
    }
}
