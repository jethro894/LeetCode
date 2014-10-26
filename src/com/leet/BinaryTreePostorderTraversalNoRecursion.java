package com.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversalNoRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        
        if(root!=null)
        	nodes.add(root);

        while(!nodes.isEmpty()){
        	TreeNode currentNode = nodes.pop();
        	result.add(currentNode.val);
        	if(currentNode.left != null)
        		nodes.push(currentNode.left);    
        	if(currentNode.right != null)
        		nodes.push(currentNode.right);
        }
        
        Collections.reverse(result);
        return result;
    }

}
