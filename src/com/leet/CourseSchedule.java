package com.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	if(numCourses <= 0)
    		return false;
    	
    	List<DirectedGraphNode> graphNodes = new ArrayList<DirectedGraphNode>();
        for(int i = 0; i < numCourses; i++){
        	DirectedGraphNode newNode = new DirectedGraphNode(i);
        	graphNodes.add(newNode);
        }
        
        for(int[] prerequisite : prerequisites){
        	if(prerequisite.length == 2){
        		graphNodes.get(prerequisite[0]).children.add(graphNodes.get(prerequisite[1]));
        	}
        }
        
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        for(DirectedGraphNode node : graphNodes){
        	if(!visited.contains(node)){
        		Set<DirectedGraphNode> history = new HashSet<DirectedGraphNode>();
        		boolean hasCycle = dfs(node, history);
        		if(hasCycle)
        			return false;
        	}
        }
        //return true;
    }
    
    public boolean dfs(DirectedGraphNode node, Set<DirectedGraphNode> history){
    	if(node == null)
    		return false;
    	
    	history.add(node);
    	
    	if(node.children.size() == 0)
    		return false;
    	else{
    		for(DirectedGraphNode child : node.children){
    			if(!history.contains(child)){
    				return dfs(child, history);
    			}else{
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
}
