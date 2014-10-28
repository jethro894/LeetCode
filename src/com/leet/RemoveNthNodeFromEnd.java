package com.leet;

public class RemoveNthNodeFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        int i = n;
        ListNode lead = head;
        ListNode behind;
        while(i >= 0){
            lead = lead.next;
            i--;
        }
        
        behind = dummy;
        while(lead != null){
            lead = lead.next;
            behind = behind.next;
        }
        if(behind.next != null)
            behind.next = behind.next.next;
        return dummy.next;
    }
}
