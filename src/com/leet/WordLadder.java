package com.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
        
        List<UndirectedGraphNode> graph = new ArrayList<UndirectedGraphNode>();
        for(String s : dict){
        	UndirectedGraphNode new_node = new UndirectedGraphNode(s);
        	graph.add(new_node);
        }
        
        //grow with lettersss
        for(int i = 0; i < graph.size()-1; i++){
        	for(int j = i+1; j < graph.size(); j++){
        		UndirectedGraphNode n1 = graph.get(i);
        		UndirectedGraphNode n2 = graph.get(j);
        		if(onlyDifferByOneLetter(n1.label, n2.label)){
        			n1.neighbors.add(n2);
        			n2.neighbors.add(n1);
        		}
        	}
    	}
        
        UndirectedGraphNode start_node = new UndirectedGraphNode(start);
        UndirectedGraphNode end_node = new UndirectedGraphNode(end);
    	for(UndirectedGraphNode ugn : graph){
    		if(onlyDifferByOneLetter(start_node.label, ugn.label)){
    			ugn.neighbors.add(start_node);
    			start_node.neighbors.add(ugn);
    		}
    		if(onlyDifferByOneLetter(end_node.label, ugn.label)){
    			ugn.neighbors.add(end_node);
    			end_node.neighbors.add(ugn);
    		}
    	}
    	graph.add(start_node);
    	graph.add(end_node);
    	
    	if(start_node.neighbors.size() == 0 || end_node.neighbors.size() == 0)
    		return 0;
    	
    	return bfs(start_node, end_node);     
    }
	
	public int bfs(UndirectedGraphNode start, UndirectedGraphNode end){
		
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		
		queue.add(start);
		visited.add(start);
		int level = 1;
		int last_level = 1;
		int cur_level = 0;
		while(!queue.isEmpty()){
			UndirectedGraphNode cur = queue.poll();
			last_level--;
			for(UndirectedGraphNode ugn: cur.neighbors){
				if(onlyDifferByOneLetter(ugn.label, cur.label))
					return level;
				if(!visited.contains(ugn)){
					cur_level++;
					queue.add(ugn);
					visited.add(ugn);
				}
			}
			if(last_level == 0){
				last_level = cur_level;
				cur_level = 0;
				level++;
			}
		}
		return 0;
	}
	
	public boolean onlyDifferByOneLetter(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		int diff = 0;
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				diff++;
				if(diff > 1)
					return false;
			}
		}
		if(diff == 1)
			return true;
		return false;
	}
	
	
	class UndirectedGraphNode {
		String label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(String x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}
}
