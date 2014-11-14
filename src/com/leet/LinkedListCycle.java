package com.leet;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head == null)
			return false;
		
        ListNode slow = head;
        ListNode fast = head;
        
        while(true){
        	if(slow.next != null && slow.next.next != null){
        		slow = slow.next.next;
        	}else
        		return false;
        	
        	if(fast.next != null && fast.next.next != null && fast.next.next.next != null){
        		fast = fast.next.next.next;
        	}else
        		return false;
        	
        	if(slow == fast)
        		return true;
        }
    }
}
