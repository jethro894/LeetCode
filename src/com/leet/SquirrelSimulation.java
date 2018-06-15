package com.leet;

public class SquirrelSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height = 5;
		int width = 7;
		int[] tree = new int[] {2,2};
		int[] squirrel = new int[] {4,4};
		int[][] nuts = new int[][] {{3,0},{2,5}};
		
		System.out.println(new SquirrelSimulation().minDistance(height, width, tree, squirrel, nuts));
	}
	
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        
		int maxDiff = 0;
		int sum = 0;
        for (int i = 0; i < nuts.length; i++) {
        	int[] nut = nuts[i];
        	
        	int treeDist = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
        	sum += treeDist;
        	
        	int sqrlDist = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
        	
        	maxDiff = Math.max(maxDiff, treeDist - sqrlDist);
        }

        return 2*sum - maxDiff; 
    }

}
