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
       
        if(root == null)
        	return levels;
        
        queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        TreeNode current;
        int this_level = 0;
        int this_level_left = 1;
        List<Integer> level = new ArrayList<Integer>();
        while(!queue.isEmpty()){
        	current = queue.poll();
        	this_level_left--;
        	level.add(current.val);
        	if(current.left != null){
        		queue.add(current.left);
        		this_level++;
        	}
        	if(current.right != null){
        		queue.add(current.right);
        		this_level++;
        	}
        	if(this_level_left == 0){
        		this_level_left = this_level;
        		this_level = 0;
        		levels.add(level);
        		level = new ArrayList<Integer>();
        	}
        }
        return levels;
    }
	

}
