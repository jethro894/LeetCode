package com.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class KeyboardRows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = new String[] {"Hello","Alaska","Dad","Peace"};
		System.out.println(new KeyboardRows().findWords(words).length);
	}

	public String[] findWords(String[] words) {
        Character[] row1 = new Character[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        Character[] row2 = new Character[] {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        Character[] row3 = new Character[] {'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        
        Set<Character> row1Set = new HashSet<Character>(Arrays.asList(row1));
        Set<Character> row2Set = new HashSet<Character>(Arrays.asList(row2));
        Set<Character> row3Set = new HashSet<Character>(Arrays.asList(row3));
        
        List<String> res = new ArrayList<String>();
        
        wordLoop:
        for(String word : words){
            char[] array = word.toLowerCase().toCharArray();
            
            System.out.println(word);
            int set = 1;
            for(int i = 0; i < array.length; i++){
                if(i == 0){
                    set = getRow(array[i], row1Set, row2Set, row3Set);
                    System.out.println(set);
                }else{
                    if(set != getRow(array[i], row1Set, row2Set, row3Set)){
                    	System.out.println(array[i]);
                    	System.out.println(getRow(array[i], row1Set, row2Set, row3Set));
                        continue wordLoop;
                    }
                }
            }
            res.add(word);
        }
        
        return res.toArray(new String[res.size()]);
    }
    
    public int getRow(char c, Set<Character> row1Set, Set<Character> row2Set, Set<Character> row3Set){
        if(row1Set.contains(c)){
            return 1;
        }else if(row2Set.contains(c)){
            return 2;
        }else if(row3Set.contains(c)){
            return 3;
        }else{
            return 0;
        }
    }
}
