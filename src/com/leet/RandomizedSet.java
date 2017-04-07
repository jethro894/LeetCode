package com.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet obj = new RandomizedSet();
		obj.insert(1);
		obj.insert(10);
		obj.insert(20);
		obj.insert(30);
		
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
	}
	
	List<Integer> array;
	Map<Integer, Integer> idxMap;
	
	/** Initialize your data structure here. */
    public RandomizedSet() {
    	array = new ArrayList<Integer>();
    	idxMap = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(idxMap.containsKey(val)){
        	return false;
        }
        array.add(val);
        idxMap.put(val, array.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!idxMap.containsKey(val)){
        	return false;
        }
        
        int idx = idxMap.get(val);
        
        if(idx != array.size()-1){
        	array.set(idx, array.get(array.size()-1));
            array.remove(array.size()-1);
            
            idxMap.remove(val);
            idxMap.put(array.get(idx), idx);
        }else{
        	 array.remove(array.size()-1);
             idxMap.remove(val);
        }
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random r = new Random();
        return array.get(r.nextInt(array.size()));
    }
}
