package com.leet.tripad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyStringBuilder {
	private List<Character> chars;
	
	public MyStringBuilder(){
		chars = new ArrayList<Character>();
	}
	
	public MyStringBuilder(String s){
		chars = new ArrayList<Character>();
		for(int i= 0; i < s.length(); i++){
			chars.add(s.charAt(i));
		}
	}
	
	public MyStringBuilder(char[] s){
		chars = new ArrayList<Character>();
		for(int i= 0; i < s.length; i++){
			chars.add(s[i]);
		}
	}
	
	public void append(char c){
		chars.add(c);
	}
	
	public void append(char[] str){
		for(char c : str)
			chars.add(c);
	}
	
	public void append(int digit){
		chars.add((char)(digit + '0'));
	}
	
	public char charAt(int i){
		if(i >= 0 && i < chars.size())
			return chars.get(i);
		else
			return (char) -1;
	}
	
	public MyStringBuilder delete(int i){
		chars.remove(i);
		return this;
	}
	
	public void insert(int offset, char c){
		List<Character> before = chars.subList(0, offset);
		List<Character> after = chars.subList(offset, chars.size());
		before.add(c);
		before.addAll(after);
		chars = before;
	}
	
	public int length(){
		return chars.size();
	}
	
	public void setLength(int l){
		List<Character> sublist = chars.subList(0, l);
		chars = sublist;
	}
	
	public void setCharAt(int i, char c){
		chars.set(i, c);
	}
	
	public void subString(int start, int end){
		chars = chars.subList(start, end);
	}
	
	public MyStringBuilder reverse(){
		Collections.reverse(chars);
		return this;
	}
	
	public String toString(){
		char[] str = new char[chars.size()];
		for(int i = 0; i < str.length; i++)
			str[i] = chars.get(i);
		return new String(str);
	}
}
