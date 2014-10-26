package com.leet;

public class Add2Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null)
        	return l2;
        
        if(l2 == null)
        	return l1;
      
		int value = (l1.val + l2.val) % 10;
		int carry = (l1.val + l2.val) / 10;
		
		ListNode head = new ListNode(value);
		ListNode tail = head;
		ListNode l1Tail = l1.next;
		ListNode l2Tail = l2.next;

		while(l1Tail != null || l2Tail != null || carry > 0){
			int thisvalue = carry;
			
			if(l1Tail != null){
			    thisvalue += l1Tail.val;
				l1Tail = l1Tail.next;
			}	
			
			if(l2Tail != null){
			    thisvalue += l2Tail.val;
				l2Tail = l2Tail.next;
			}
			
			value = thisvalue % 10;
			carry = thisvalue / 10;
			
			ListNode newNode = new ListNode(value);
			tail.next = newNode;
			tail = newNode;
		}
        
        return head;
    }
	
	
}
