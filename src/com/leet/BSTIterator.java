package com.leet;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		
		TreeNode n = root;
        while(n != null){
        	stack.push(n);
        	n = n.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = stack.pop();
        
        TreeNode cur = n.right;
        while(cur != null){
        	stack.push(cur);
        	cur = cur.left;
        }
        
        return n.val;
    }
}
