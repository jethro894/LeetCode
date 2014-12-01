package com.leet;

public class JumpGameII {
	public int jump(int[] A) {
        if(A.length == 0)
        	return 0;
        
        int jump = 0;
        int reachable_sofar = 0;
        int reachable_next = 0;
        for(int i = 0; i < A.length; i++){
        	if(i > reachable_next)
        		return -1;
        	if(i > reachable_sofar){
        		reachable_sofar = reachable_next;
        		jump++;
        	}
        	reachable_next = Math.max(reachable_next, i+A[i]);
        }
        return jump;
    }
}
