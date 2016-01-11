package com.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsmorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for(int i : new IsmorphicStrings().analyze("title")){
			System.out.print(i + ",");
		}*/
		System.out.println(new IsmorphicStrings().isIsomorphic("paper", "title"));
	}

	public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null)
        	return true;
        if(s == null || t == null)
        	return false;
        else{
        	if(s.length() != t.length())
        		return false;
        	else{
        		/*if(analyze(s).equals(analyze(t)))
        			return true;
        		else
        			return false;*/
        		return analyze(s,t);
        	}
        }
    }
	
	public List<Integer> analyze(String s){
		Map<Character, Integer> firstApperance = new HashMap<Character, Integer>();
		List<Integer> result = new ArrayList<Integer>();
		int seed = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(firstApperance.containsKey(c)){
				int firstPos = firstApperance.get(c);
				int firstCharCode = result.get(firstPos);
				result.add(firstCharCode);
			}else{
				firstApperance.put(c, result.size());
				result.add(seed);
				seed++;
			}
		}
		return result;
	}
	
	public boolean analyze(String s, String t){
		Map<Character, Integer> firstApperanceS = new HashMap<Character, Integer>();
		Map<Character, Integer> firstApperanceT = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			boolean sContainsCs = firstApperanceS.containsKey(cs);
			boolean tContainsCt = firstApperanceT.containsKey(ct);
			if( sContainsCs && tContainsCt ){
				if(firstApperanceS.get(cs) != firstApperanceT.get(ct))
					return false;
			}
			else if(!sContainsCs && !tContainsCt){
				firstApperanceS.put(cs, i);
				firstApperanceT.put(ct, i);
			}
			else 
				return false;
		}
		return true;
	}
}
