package com.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int numCourses = 4;
		int[][] prerequisites=  new int[][] {{1,0},{2,1},{3,2},{1,3}};*/
		
		int numCourses = 8;
		int[][] prerequisites=  new int[][] {{1,0}, {2,6}, {1,7}, {6,4}, {7,0}, {0,5}};
		
		System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
		
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0)
    		return false;
    	
    	List<DirectedGraphNode> graphNodes = new ArrayList<DirectedGraphNode>();
    	int[] indegrees = new int[numCourses];
    	int[] outdegrees = new int[numCourses];
    	
        for(int i = 0; i < numCourses; i++){
        	DirectedGraphNode newNode = new DirectedGraphNode(i);
        	graphNodes.add(newNode);
        }
        
        for(int[] prerequisite : prerequisites){
        	if(prerequisite.length == 2){
        		graphNodes.get(prerequisite[0]).children.add(graphNodes.get(prerequisite[1]));
        		indegrees[graphNodes.get(prerequisite[1]).label]++;
        		outdegrees[graphNodes.get(prerequisite[0]).label]++;
        	}
        }
        
        Set<DirectedGraphNode> totalVisited = new HashSet<DirectedGraphNode>();
        for(DirectedGraphNode node : graphNodes){
        	if(indegrees[node.label] == 0){
        		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        		boolean hasCycle = dfs(node, visited, outdegrees);
        		totalVisited.addAll(visited);
        		if(hasCycle)
        			return false;
        	}
        }
        System.out.println(totalVisited.size());
        /*if(totalVisited.size() < numCourses){
        	return false;
        }*/
        return true;
    }
    
    public boolean dfs(DirectedGraphNode node, Set<DirectedGraphNode> history, int[] outdegrees){
    	if(node == null)
    		return false;
    	
    	System.out.println("visiting: " + node.label);
    	System.out.println("children size: " + node.children.size());
    	history.add(node);
    	
    	if(node.children.size() == 0)
    		return false;
    	else{
    		for(DirectedGraphNode child : node.children){
    			System.out.println("visiting child: " + child.label);
    			if(!history.contains(child)){
    				boolean hasCycle = dfs(child, history, outdegrees);
    				if(hasCycle){
    					return hasCycle;
    				}
    			}else{
    				if(outdegrees[child.label] == 0){
    					return false;
    				}else{
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    class DirectedGraphNode {
    	int label;
    	List<DirectedGraphNode> children;
    	public DirectedGraphNode(int x){
    		this.label = x;
    		children = new ArrayList<DirectedGraphNode>();
    	}
    }
}
