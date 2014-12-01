package com.leet;

public class JumpGame {
	public boolean canJump(int[] A) {
        if(A.length == 0)
        	return true;
        
        int max_jump_here = A[0];
        int max_jump_sofar = A[0];
        
        for(int i = 0; i < A.length; i++){
        	if(max_jump_sofar < i){
        		return false;
        	}
        	max_jump_here = i + A[i];
        	max_jump_sofar = Math.max(max_jump_sofar, max_jump_here);
        	if(max_jump_sofar >= A.length-1)
        		return true;
        }
        return false;
    }
}
