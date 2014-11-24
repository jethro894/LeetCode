package com.leet;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
        	return head;
        
        ListNode helper = new ListNode(Integer.MIN_VALUE);
        helper.next = head;
        
        ListNode slow = helper;
        ListNode fast = helper;
        
        while(fast.next != null){
        	if(fast.next.val < x){
        		if(fast != slow){
        			ListNode later = fast.next.next;
        			fast.next.next = slow.next;
        			slow.next = fast.next;
        			fast.next = later;
        		}else
        			fast = fast.next;
        		slow = slow.next;
        	}else
        		fast = fast.next;
        }
        
        return helper.next;
    }
}
