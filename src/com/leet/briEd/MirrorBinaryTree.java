package com.leet.briEd;

import com.leet.TreeNode;

public class MirrorBinaryTree {
	public TreeNode mirrorCopy(TreeNode root){
		if(root == null)
			return null;
		
		TreeNode new_root = new TreeNode();
		helper(root, new_root);
		return new_root;
	}
	
	public void helper(TreeNode old, TreeNode copied){
		if(old == null)
			return;
		
		copied.val = old.val;
		
		if(old.left != null){
			TreeNode new_right = new TreeNode();
			copied.right = new_right;
			helper(old.left, new_right);
		}
		
		if(old.right != null){
			TreeNode new_left = new TreeNode();
			copied.left = new_left;
			helper(old.right, new_left);
		}
	}
}
