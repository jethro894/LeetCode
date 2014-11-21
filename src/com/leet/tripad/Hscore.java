package com.leet.tripad;

import java.util.Arrays;

public class Hscore {
	
	public static void main(String[] args){
		int[] A = {6,4,2,5,3,1,1,5,8,6,4,5,9};
		System.out.println(new Hscore().hscore(A));
	}
	public int hscore(int[] citations){
		if(citations.length == 0)
			return 0;
		
		int articles = citations.length;
		Arrays.sort(citations);
		
		int i;
		for(i = articles-1; i >= 0; i--){
			if(articles-1 - i > citations[articles-1-i])
				break;
		}
		return (articles - 1 - i);
	}
}
