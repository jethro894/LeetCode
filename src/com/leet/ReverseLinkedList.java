package com.leet;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        ListNode current = head;
        ListNode last = null;
        ListNode next = null;
        while(current != null){
        	next = current.next;
        	current.next = last;
        	last = current;
        	current = next;
        }
        
        return last;
    }
}
