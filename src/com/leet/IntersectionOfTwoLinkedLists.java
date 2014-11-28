package com.leet;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        	return null;
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        int m = 0;
        while(curA != null){
        	curA = curA.next;
        	m++;
        }
        
        int n = 0;
        while(curB != null){
        	curB = curB.next;
        	n++;
        }
        
        curA = headA;
    	curB = headB;
        if(m > n){
        	int dif = m-n;
        	while(dif > 0){
        		curA = curA.next;
        		dif--;
        	}
        }else if(m < n){
        	int dif = n-m;
        	while(dif > 0){
        		curB = curB.next;
        		dif--;
        	}
        }
        
        while(curA != null && curB != null){
        	if(curA == curB)
        		return curA;
        	else{
        		curA = curA.next;
        		curB = curB.next;
        	}
        }
        
        return null;
    }
}
