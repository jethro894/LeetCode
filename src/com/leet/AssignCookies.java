package com.leet;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] g = new int[]{1,2};
		int[] s = new int[]{1,2,3};
		
		System.out.println(new AssignCookies().findContentChildren(g, s));
	}
	
	public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        int greedStart = g.length-1;
        for(int i = 0; i < s.length; i++){
        	//for each cookie, find the greedest kid it can content
        	int j = greedStart;
        	while(j >= 0 && (g[j] > s[i] || g[j] < 0)){
        		j--;
        	}
        	
        	//two possibilities now: g[j] <= s[i] so g[j] is our greedest kid
        	//or j == -1, means that this cookie can content no kind
        	if(j < 0){
        		//waste cookie
        	}else{
        		g[j] = -g[j];
        		res++;
        		
        		if(j == greedStart){
        			greedStart--;
        		}
        	}
        }
        
        return res;
    }

}
