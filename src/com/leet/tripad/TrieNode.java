package com.leet.tripad;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	char c;
	TrieNode parent;
	TrieNode[] children;
	boolean isLeaf;
	boolean isWord;
	
	public TrieNode(){
		children = new TrieNode[26];
	    isLeaf = true;
	    isWord = false;
	}
	
	public TrieNode(char character){
	    this();
	    this.c = character;
	}
	
	protected void addWord(String word){
		if(word.length() == 0)
			return;
		
		isLeaf = false;
		int charIndex = word.charAt(0) - 'a';
		
		if(children[charIndex] == null){
			children[charIndex] = new TrieNode(word.charAt(0));
			children[charIndex].parent = this;
		}
		
		if(word.length() > 1)
			children[charIndex].addWord(word.substring(1));
		else
			children[charIndex].isWord = true;
	}
	
	protected TrieNode getNode(char c){
		int charIndex = (int)(c - 'a');
		if(charIndex >= 0 && charIndex < 26)
			return children[charIndex];
		else
			return null;
	}
	
	protected List<String> getWords(List<Character> chars){
		List<String> words = new ArrayList<String>();
		for(TrieNode child : children){
			if(child != null){
				List<Character> newchars = new ArrayList<Character>(chars);
				newchars.add(child.c);
				words.addAll(child.getWords(newchars));
			}
		}
		String thisword = null;
		if(isWord){
			StringBuilder sb = new StringBuilder();
			for(char c : chars)
				sb.append(c);
			thisword = sb.toString();
		}
		words.add(thisword);
		return words;
	}
}
