package com.leet;

public class DeleteNodeInListList {
	public void deleteNode(ListNode node) {
        if(node.next != null){
        	node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
