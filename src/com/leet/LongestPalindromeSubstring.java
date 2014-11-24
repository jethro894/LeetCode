package com.leet;

public class LongestPalindromeSubstring {
	public static void main(String[] args){
		System.out.println(new LongestPalindromeSubstring().longestPalindrome("bb"));
	}
	public String longestPalindrome(String s) {
        if(s.length() == 0)
        	return null;
        
        int max_length = 0;
        String longest_substr_sofar = "";
        
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i = 0; i < s.length(); i++)
        	sb.append(s.charAt(i) + "#");
        
        String base = sb.toString();
        System.out.println(base);
        for(int i = 0; i < base.length(); i++){
        	System.out.println("i = " + i);
        	int j = 1;
        	while(i - j >= 0 && i + j <= base.length() -1){
        		if(base.charAt(i-j) != base.charAt(i+j)){
        			break;
        		}
        		j++;
        	}
        	j--;
        	System.out.println("j = " + j);
        	int real_length = i % 2 == 0 ? (j % 2 == 0 ? j : j+1):(j % 2 == 0 ? j+1 : j);
        	System.out.println("real_length: " + real_length);
        	if(real_length > max_length){
        		max_length = real_length;
        		int start = (i - j) % 2 == 0 ? (i-j)/2 : (i-j-1)/2;
        		System.out.println("start from: " + start);
        		longest_substr_sofar = s.substring(start, start+real_length);
        	}
        	System.out.println();
        }
        return longest_substr_sofar;
    }
}
