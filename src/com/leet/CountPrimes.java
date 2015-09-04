package com.leet;

import java.util.LinkedList;
import java.util.Queue;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int countPrimes(int n) {
        if(n <= 1)
        	return 0;
        
        Queue<Integer> seeds = new LinkedList<Integer>();
        LinkedList<Integer> candidates = new LinkedList<Integer>();
        boolean[] draft = new boolean[n];
        
        seeds.add(2);
        while(!seeds.isEmpty()){
        	int seed = seeds.poll();
        	
        }
    }
}
