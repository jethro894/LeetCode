package com.leet;

public class PopulatingNextRightPointersII {
	public void connect(TreeLinkNode root) {
        if(root == null)
        	return;
        
        if(root.left == null && root.right == null)
        	return;
        
        TreeLinkNode nextToItsChildren = null;
        TreeLinkNode parentNext = root.next;
        while(parentNext != null){
        	if(parentNext.left == null && parentNext.right == null)
        		parentNext = parentNext.next;
        	else
        		break;
        }
        if(parentNext != null){
        	if(parentNext.left != null)
        		nextToItsChildren = parentNext.left;
        	else
        		nextToItsChildren = parentNext.right;
        }
        
        if(root.left != null){
        	if(root.right != null)
        		root.left.next = root.right;
        	else
        		root.left.next = nextToItsChildren;
        }
        
        if(root.right != null)
        	root.right.next = nextToItsChildren;
        
        connect(root.right);
        connect(root.left);
    }
}
