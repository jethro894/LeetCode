package com.leet;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        ListNode helper = new ListNode(0);
        helper.next = head;
        
        ListNode slow = helper;
        ListNode fast = head;
        while(fast != null){
        	if(fast.next != null && slow.next.val == fast.next.val){
        		fast = fast.next;
        		continue;
        	}
        	
        	if(slow.next != fast){
        		slow.next = fast.next;
        	}else{
        		slow = slow.next;
        	}
        	fast = fast.next;
        }
        
        return helper.next;
    }
}
