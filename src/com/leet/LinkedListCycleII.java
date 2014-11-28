package com.leet;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while(fast != null && fast.next != null && fast != slow){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        if(fast == null || fast.next == null)
        	return null;
        
        fast = head;
        while(fast != slow){
        	fast = fast.next;
        	slow = slow.next;
        }
        
        return slow;
    }
}
