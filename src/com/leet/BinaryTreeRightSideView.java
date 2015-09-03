package com.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
        	return list;
        
        queue.add(root);
        int next_level = 0;
        int this_level_left = 1;
        while(!queue.isEmpty()){
        	TreeNode current = queue.poll();
        	this_level_left--;
        	if(current.left != null){
        		queue.add(current.left);
        		next_level++;
        	}
        	if(current.right != null){
        		queue.add(current.right);
        		next_level++;
        	}
        	if(this_level_left == 0){
        		this_level_left = next_level;
        		next_level = 0;
        		list.add(current.val);
        	}
        }
        return list;
    }
}
