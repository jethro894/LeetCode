package com.leet;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		
		List<Integer> in_order_traverse = new ArrayList<Integer>();
		dfs(root, in_order_traverse);
		
		int pre = in_order_traverse.get(0);
		int cur;
		for(int i = 1; i < in_order_traverse.size(); i++){
			cur = in_order_traverse.get(i);
			if(cur <= pre)
				return false;
			pre = cur;
		}
		return true;
    }
	
	public void dfs(TreeNode n, List<Integer> list){
		if(n == null)
			return;
		
		if(n.left != null)
			dfs(n.left, list);
		
		list.add(n.val);
		
		if(n.right != null)
			dfs(n.right, list);
	}
}
