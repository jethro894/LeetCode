package com.leet.tripad;

import java.util.ArrayList;
import java.util.List;

public class PrefixTrie {
	
	private TrieNode root;
	
	public PrefixTrie(){
		root = new TrieNode();
	}
	
	public void addWord(String word){
		root.addWord(word.toLowerCase());
	}
	
	public List<String> getWords(String prefix){
		TrieNode lastNode = root;
		for(int i = 0; i < prefix.length(); i++){
			if(lastNode == null)
				break;
			lastNode = lastNode.getNode(prefix.charAt(i));
		}
		
		if(lastNode == null)
			return null;
		else{
			List<Character> chars = new ArrayList<Character>();
			for(char c : prefix.toCharArray())
				chars.add(c);
			return lastNode.getWords(chars);
		}
	}
}
