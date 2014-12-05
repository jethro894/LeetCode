package com.leet;

import java.util.HashMap;

public class CloneGraph {
	HashMap<UndirectedGraphNode, UndirectedGraphNode> visited;
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
        	return null;
        visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode new_base = new UndirectedGraphNode(node.label);
        visited.put(node, new_base);
        dfs(node, new_base);
        return new_base;
    }
	
	public void dfs(UndirectedGraphNode old_n, UndirectedGraphNode new_n){
		if(old_n == null)
			return;
		
		for(UndirectedGraphNode child : old_n.neighbors){
			if(!visited.containsKey(child)){
				UndirectedGraphNode new_c = new UndirectedGraphNode(child.label);
				new_n.neighbors.add(new_c);
				visited.put(child, new_c);
				dfs(child, new_c);
			}else{
				new_n.neighbors.add(visited.get(child));
			}
		}
	}
}
