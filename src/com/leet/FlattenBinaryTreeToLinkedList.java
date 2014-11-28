package com.leet;

public class FlattenBinaryTreeToLinkedList {
	TreeNode lastVisited; 
	public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
        	return;
        lastVisited = null;
        helper(root);
    }
	
	public void helper(TreeNode n){
		if(n == null)
			return;
		
		TreeNode right = n.right;
		if(lastVisited != null){
			lastVisited.left = null;
			lastVisited.right = n;
		}
		lastVisited = n;
		helper(n.left);
		helper(right);
	}
}
