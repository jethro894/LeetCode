package com.leet;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public TreeNode(int x) { val = x; }
	public TreeNode() {}
	
	public boolean isLeaf(){
		if(this.left == null && this.right == null)
			return true;
		return false;
	}
	public void print(){
		System.out.print(this.val + " ");
	}
}
