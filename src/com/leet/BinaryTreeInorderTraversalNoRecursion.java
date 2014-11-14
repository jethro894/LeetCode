package com.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalNoRecursion {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null)
            return result;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
            	TreeNode left = node.left;
            	node.left = null;
            	stack.push(node);
            	stack.push(left);
            	continue;
            }
            else{
            	result.add(node.val);
            }
            if(node.right != null){
            	stack.push(node.right);
            }
        }
        return result;
    }
}
