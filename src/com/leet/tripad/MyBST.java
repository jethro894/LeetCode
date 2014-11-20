package com.leet.tripad;

import com.leet.TreeNode;

public class MyBST {
	TreeNode root;
	
	public TreeNode search(TreeNode n, int k){
		if(n == null)
			return null;
		
		if(k == n.val)
			return n;
		
		if(k < n.val)
			return search(n.left, k);
		else
			return search(n.right, k);
	}
	
	public TreeNode searchIterative(TreeNode n, int k){
		if(n == null)
			return null;
		
		while(n != null && k != n.val){
			if(k < n.val)
				n = n.left;
			else
				n = n.right;
		}
		
		return n;
	}
	
	public TreeNode findMin(TreeNode n){
		if(n == null)
			return null;
		while(n.left != null)
			n = n.left;
		return n;
	}
	
	public TreeNode findMax(TreeNode n){
		if(n == null)
			return null;
		while(n.right != null)
			n = n.right;
		return n;
	}
	
	public TreeNode findSuccessor(TreeNode n){
		if(n == null)
			return null;
		if(n.right != null)
			return findMin(n.right);
		TreeNode p = n.parent;
		while(p != null && n == p.right){
			n = p;
			p = p.parent;
		}
		return p;
	}
	
	public TreeNode findPredecessor(TreeNode n){
		if(n == null)
			return null;
		if(n.left != null)
			return findMax(n.left);
		TreeNode p = n.parent;
		while(p != null && n == p.left){
			n = p;
			p = p.parent;
		}
		return p;
	}
}
