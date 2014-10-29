package com.leet;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3};
		permute(num);
	}

	public static List<List<Integer>> permutations;
	
	public static List<List<Integer>> permute(int[] num) {
        if(num.length == 0) {return null;}
        
        permutations = new ArrayList<List<Integer>>();
        grow(new ArrayList<Integer>(), num);
        
        return permutations;
        
    }
	
	public static void grow(List<Integer> permutation_sofar, int[] num_remained){
		if(num_remained.length == 0){
			permutations.add(permutation_sofar);
			return;
		}
		
		for(int i = 0; i < num_remained.length; i++){
			List<Integer> next = new ArrayList<Integer>(permutation_sofar);
			next.add(num_remained[i]);
			grow(next, toIntArray(toIntegerList(num_remained, i)));
		}
	}
	
	public static List<Integer> toIntegerList(int[] array, int i_to_eliminate){
		List<Integer> next = new ArrayList<Integer>();
		for(int j = 0; j < array.length; j++){
			if(j != i_to_eliminate){
				next.add(array[j]);
			}
		}
		return next;
			
	}
	public static int[] toIntArray(List<Integer> list)  {
	    int[] ret = new int[list.size()];
	    int i = 0;
	    for (Integer e : list)  
	        ret[i++] = e.intValue();
	    return ret;
	}
}
