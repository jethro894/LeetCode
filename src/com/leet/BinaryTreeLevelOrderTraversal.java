package com.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	List<List<Integer>> levels;
	Queue<TreeNode> queue;
	public List<List<Integer>> levelOrder(TreeNode root) {
        levels = new ArrayList<List<Integer>>();
        queue = new LinkedList<TreeNode>();
        if(root == null)
        	return levels;
        
        levels.add(new ArrayList<Integer>(root.val));
        queue.add(root);
        bfs(queue.poll());
        return levels;
    }
	
	public void bfs(TreeNode node){
		
	}
}
