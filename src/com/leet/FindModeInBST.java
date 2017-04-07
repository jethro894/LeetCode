package com.leet;

import java.util.List;

public class FindModeInBST {
	
	Integer mode = null;
    int max = 0;
    Integer cur = null;
    List<Integer> res = null;
	public int[] findMode(TreeNode root) {
        if(root == null){
        	return null;
        }
        
        cur = root.val;
        helper(root, 1);
    }
	
	public void helper(TreeNode node, int count){
		
		if(node.left != null){
			helper(node.left, count);
		}
		
		if(cur != null){
			if(cur == node.val){
				count++;
			}
		}else{
			cur = node.val;
			count = 1;
		}
		count++;
		if(count > max){
			max = count;
			mode = node.val;
		}
		
		if()
	}
}
