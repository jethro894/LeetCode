package com.leet;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0 || dungeon[0].length == 0)
        	return -1;
        
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        
        int[][] minHP = new int[rows][columns];
        for(int i = rows-1; i >= 0; i--){
        	for(int j = columns - 1; j >= 0; j--){
        		if(i == rows-1 && j == columns-1)
        			minHP[i][j] = dungeon[i][j] < 0? 1-dungeon[i][j] : 1;
        		
        		else if(i == rows-1)
        			minHP[i][j] = Math.max(minHP[i][j+1]-dungeon[i][j], 1);
        			
        		else if (j == columns-1)
        			minHP[i][j] = Math.max(minHP[i+1][j]-dungeon[i][j], 1);
        		
        		else
        			minHP[i][j] = Math.min(Math.max(minHP[i][j+1]-dungeon[i][j], 1), Math.max(minHP[i+1][j]-dungeon[i][j], 1));
        	}
        }
        
        return minHP[0][0];
    }
}
