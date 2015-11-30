package com.leet;

import java.util.LinkedList;
import java.util.Queue;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountPrimes().countPrimes(100));
	}

    public int countPrimes(int n) {
        if(n <= 1)
        	return 0;
        
        //Queue<Integer> seeds = new LinkedList<Integer>();
        //LinkedList<Integer> candidates = new LinkedList<Integer>();
        boolean[] draft = new boolean[n];
        
        int count = 0;
        
        for(int i = 2; i*2 < n; i++){
        	if(draft[i-1] == false){
        		//candidates.add(i);
        		int multiplierMax = n/i;
        		//System.out.println("i: " + i + ", multiplierMax: " + multiplierMax);
        		for(int j = 2; j <= multiplierMax; j++){
            		draft[j*i-1] = true;
            		//System.out.println(j*i + " is not prime.");
            	}
        	}
        }
        
        for(int i = 2; i <= n; i++){
        	if(draft[i-1] == false){
        		//System.out.print(i+",");
        		count++;
        	}
        }
        
        return count;
    }
}
