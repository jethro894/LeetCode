package com.leet;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode {
	int label;
	List<DirectedGraphNode> children;
	public DirectedGraphNode(int x){
		this.label = x;
		children = new ArrayList<DirectedGraphNode>();
	}
}
