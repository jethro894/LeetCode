package com.leet;

public class LongestUnivaluePath {
	int max;
    public int longestUnivaluePath(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	max = 0;
    	helper(root);
        return max;
    }
    
    public int helper(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	
    	int max_left = helper(node.left);
    	if (node.left != null) {
    		if (node.left.val == node.val) {
    			max_left += 1;
    		} else {
    			max_left = 0;
    		}
    	} else {
            max_left = 0;
        }
    	
    	int max_right = helper(node.right);
    	if (node.right != null) {
    		if (node.right.val == node.val) {
    			max_right += 1;
    		} else {
    			max_right = 0;
    		}
    	} else {
            max_right = 0;
        }
    	
    	max = Math.max(max, max_right + max_left);
    	
    	return Math.max(max_left, max_right);
    }
}
