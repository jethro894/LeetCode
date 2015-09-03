package com.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String s : new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
			System.out.println(s);
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        Set<Integer> counts = new HashSet<Integer>();
        if(s.length() >= 10){
        	for(int i = 0; i <= s.length()-10; i++){
        		int sub = strToInt(s.substring(i, i+10));
        		if(counts.contains(sub)){
        			list.add(intToStr(sub));
        		}else
        			counts.add(sub);
        	}
        }
        return list;
    }
	
	public int strToInt(String atcg){
		char[] set = new char[]{'A','C','G','T'};
		char[] array = atcg.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(char c : array){
			if(c == set[0])
				sb.append('1');
			else if(c == set[1])
				sb.append('2');
			else if(c == set[2])
				sb.append('3');
			else if(c == set[3])
				sb.append('4');
			else
				return 0;
		}
		int result = Integer.parseInt(sb.toString());
		return result;
	}
	
	public String intToStr(int atcg){
		char[] set = new char[]{'1','2','3','4'};
		char[] array = Integer.toString(atcg).toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(char c : array){
			if(c == set[0])
				sb.append('A');
			else if(c == set[1])
				sb.append('C');
			else if(c == set[2])
				sb.append('G');
			else if(c == set[3])
				sb.append('T');
			else
				return "";
		}
		return sb.toString();
	}

}
