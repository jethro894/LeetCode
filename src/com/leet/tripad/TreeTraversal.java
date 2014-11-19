package com.leet.tripad;

import java.util.LinkedList;
import java.util.Queue;

import com.leet.TreeNode;

public class TreeTraversal {

	public void BFS(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.remove();
			System.out.println(node.val);
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
	}
	
	public void DFS(TreeNode root){
		if(root == null)
			return;
		
		System.out.println(root.val);
		if(root.left != null)
			DFS(root.left);
		if(root.right != null)
			DFS(root.right);
	}
	
}
