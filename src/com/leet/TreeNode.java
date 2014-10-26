package com.leet;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	TreeNode() {}
	
	public boolean isLeaf(){
		if(this.left == null && this.right == null)
			return true;
		return false;
	}
	public void print(){
		System.out.print(this.val + " ");
	}
}
