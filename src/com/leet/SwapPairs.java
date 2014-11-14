package com.leet;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		
		ListNode node0 = new ListNode(0);
		node0.next = head;
		ListNode pre = node0;
		ListNode pairhead = head;
		
        while(pairhead != null && pairhead.next != null){
        	ListNode pairheadnext = pairhead.next;
        	ListNode nextpairhead = pairhead.next.next;
    		pairhead.next = nextpairhead;
    		pairheadnext.next = pairhead;
        	pre.next = pairheadnext;
        	
        	pre = pairhead;
        	pairhead = nextpairhead;
        }
        
        return node0.next;
    }
	
}
