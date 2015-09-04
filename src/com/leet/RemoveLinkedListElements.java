package com.leet;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
        	return null;
        while(head != null && head.val == val)
        	head = head.next;
        ListNode current = head;
        while(current != null){
        	while(current.next != null && current.next.val == val)
        		current.next = current.next.next;
        	current = current.next;
        }
        return head;
    }
}
