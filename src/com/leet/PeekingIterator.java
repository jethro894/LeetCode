package com.leet;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Integer cur;
	Iterator<Integer> ite;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.ite = iterator;
		if(ite.hasNext()){
			cur = ite.next();
		}else{
			cur = null;
		}
		
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer temp = new Integer(cur);
		
		if(ite.hasNext()){
			cur = ite.next();
		}else{
			cur = null;
		}
		
		return temp;
	}

	@Override
	public boolean hasNext() {
	    return cur != null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
