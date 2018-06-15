package com.leet;

public class WallsAndGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rooms = new int[][] {
			{0, 0},
			{0, 0}
		};
		
		new WallsAndGates().wallsAndGates(rooms);
		System.out.println(rooms);
	}
    
	public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
        	return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (rooms[i][j] == 0) {
        			grow(rooms, i, j, 0);
        		}
        	}
        }
    }
	
	public void grow(int[][] rooms, int x, int y, int dist) {
		if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length) {
			return;
		}
		
		//force discover if rooms[x][y] is a door
		if (rooms[x][y] != 0 || dist > 0) {
			if (rooms[x][y] > dist) {
				rooms[x][y] = dist;
			} else {
				return;
			}
		}
		
		//up
		grow(rooms, x, y-1, dist+1);
		//down
		grow(rooms, x, y+1, dist+1);
		//left
		grow(rooms, x-1, y, dist+1);
		//right
		grow(rooms, x+1, y, dist+1);
	}

}
