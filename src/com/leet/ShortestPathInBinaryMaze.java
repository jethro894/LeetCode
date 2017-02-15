package com.leet;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = 
			{
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
		        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
		        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
		        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
		        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
		        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
		    };
		
		System.out.println(new ShortestPathInBinaryMaze().shortestPath(maze,8,9,7,7));
	}
	
	public int shortestPath(int[][] maze, int startRow, int startCol, int endRow, int endCol){
		
		if(maze == null || maze[startRow][startCol] == 0){
			return -1;
		}
		if(startRow == endRow && startCol == endCol){
			return 0;
		}
		
		int m = maze.length;
		int n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(startRow, startCol, 0));
		visited[startRow][startCol] = true;
		while(!queue.isEmpty()){
			Point cur = queue.poll();
			visited[cur.row][cur.col] = true;
			
			if(cur.row == endRow && cur.col == endCol){
				return cur.val;
			}
			
			//up
			if(cur.row > 0){
				if(!visited[cur.row-1][cur.col] && maze[cur.row-1][cur.col] != 0){
					queue.add(new Point(cur.row-1, cur.col, cur.val + maze[cur.row-1][cur.col]));
				}
			}
			
			//down
			if(cur.row < m-1){
				if(!visited[cur.row+1][cur.col] && maze[cur.row+1][cur.col] != 0){
					queue.add(new Point(cur.row+1, cur.col, cur.val + maze[cur.row+1][cur.col]));
				}
			}
			
			//left
			if(cur.col > 0){
				if(!visited[cur.row][cur.col-1] && maze[cur.row][cur.col-1] != 0){
					queue.add(new Point(cur.row, cur.col-1, cur.val + maze[cur.row][cur.col-1]));
				}
			}
			
			//right
			if(cur.col < n-1){
				if(!visited[cur.row][cur.col+1] && maze[cur.row][cur.col+1] != 0){
					queue.add(new Point(cur.row, cur.col+1, cur.val + maze[cur.row][cur.col+1]));
				}
			}
		}
		
		return -1;
	}
	
	class Point{
		int row;
		int col;
		int val;
		
		Point(int x, int y, int v){
			row = x;
			col = y;
			val = v;
		}
	}

}
