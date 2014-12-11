package com.leet;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
		String word = "aaaaaaaaaaa";
		
		System.out.println(new WordSearch().exist(board, word));
		
	}

    List<Coordinate> current_points = new ArrayList<Coordinate>();
    boolean found;
    List<boolean[]> used;
    
	public boolean exist(char[][] board, String word) {
		if(word.length() == 0) {return false;}
		if(board.length == 0) {return false;}
		else if(board[0].length == 0) {return false;}
				
        char[] word_array = word.toCharArray();
        used = new ArrayList<boolean[]>();
        found = false;
        //find the first char
        for(int i = 0; i < board.length; i++){
        	used.add(new boolean[board[i].length]);
        	for(int j = 0; j < board[i].length; j++){
        		//System.out.print(board[i][j] + ",");
        		if(board[i][j] == word_array[0]){
        			current_points.add(new Coordinate(i,j));
        		}
        		used.get(i)[j] = false;
        	}
        	//System.out.println();
        }
        if(current_points.size() == 0){
        	//System.out.println("No Starting Point");
        	return false;
        }
        	
        for(Coordinate c : current_points){
        	used.get(c.x)[c.y] = true;
        	searchForFurtherMoves(board, word_array, c, 0);
        }
        return found;
    }
	
	public void searchForFurtherMoves(char[][] board, char[] word_array, Coordinate c, int currentIndex){
			if(found)
				return;
			
			if(currentIndex == word_array.length-1){
				found = true;
				return;
			}
				
        	if(inbound(board, c.x, c.y+1)){
        		if(board[c.x][c.y+1] == word_array[currentIndex+1] && used.get(c.x)[c.y+1] == false){
        			used.get(c.x)[c.y+1] = true;
        			searchForFurtherMoves(board, word_array, new Coordinate(c.x, c.y+1), currentIndex+1);
        		}
        	}
        	if(inbound(board, c.x, c.y-1)){
        		if(board[c.x][c.y-1] == word_array[currentIndex+1] && used.get(c.x)[c.y-1] == false){
        			used.get(c.x)[c.y-1] = true;
        			searchForFurtherMoves(board, word_array, new Coordinate(c.x, c.y-1), currentIndex+1);
        		}
        	}
        	if(inbound(board, c.x-1, c.y)){
        		if(board[c.x-1][c.y] == word_array[currentIndex+1] && used.get(c.x-1)[c.y] == false){
        			used.get(c.x-1)[c.y] = true;
        			searchForFurtherMoves(board, word_array, new Coordinate(c.x-1, c.y), currentIndex+1);
        		}
        	}
        	if(inbound(board, c.x+1, c.y)){
        		if(board[c.x+1][c.y] == word_array[currentIndex+1] && used.get(c.x+1)[c.y] == false){
        			used.get(c.x+1)[c.y] = true;
        			searchForFurtherMoves(board, word_array, new Coordinate(c.x+1, c.y), currentIndex+1);
        		}
        	}
        	
        	used.get(c.x)[c.y] = false;

	}
	
	public boolean inbound(char[][] board, int x, int y){
		if(x >= 0 && x < board.length)
			if(y>=0 && y < board[x].length)
				return true;
		return false;
	}

}
