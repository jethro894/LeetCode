package com.leet;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
        if(n <= 0)
        	return 0;
        
        int[] c = new int[n + 1];
        c[0] = 1;
        c[1] = 1;
        
        for(int i = 2; i <= n; i++){
        	for(int j = 0; j < i; j++){
        		c[i] += c[j] * c[i - 1 - j];
        	}
        }
        
        return c[n];
    }
}
