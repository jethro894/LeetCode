package com.leet.tripad;

import com.leet.TreeNode;

public class DuplicatesInBST {

	int last;
	int count;
	public int duplicatesInBST(TreeNode root){
		if(root == null)
			return 0;
		
		last = root.val+1;
		helper(root);
		return count;

	}
	
	public void helper(TreeNode n){
		if(n == null)
			return;
		
		if(n.left != null)
			helper(n.left);
		
		if(n.val == last)
			count++;
		last = n.val;
		
		if(n.right != null)
			helper(n.right);
	}
}
