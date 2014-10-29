package com.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,0,-1,0,2,-2};
		int target = 0;
		
		List<List<Integer>> result = fourSum(num, target);
		
		for(List<Integer> list : result){
			for(Integer i : list){
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        
        List<IndexedCoordinate> two_group = new ArrayList<IndexedCoordinate>(); 
        for(int i = 0; i < num.length - 1; i++){
        	for(int j = i+1; j < num.length; j++){
        		IndexedCoordinate c = new IndexedCoordinate(num[i],num[j], i, j);
        		two_group.add(c);
        		//System.out.println("Adding pair: " + c.x + ", " + c.y);
        	}
        }
        
        for(IndexedCoordinate c : two_group){
        	int val = c.x + c.y;
        	for(IndexedCoordinate cc : two_group){
        		int valc = cc.x + cc.y;
        		if(c != cc && val + valc == target){
        			if(c.i == cc.i || c.j == cc.j || c.i == cc.j || c.j == cc.i)
        				continue;
        			
        			int[] tuple = new int[4];
        			tuple[0] = c.x;
        			tuple[1] = c.y;
        			tuple[2] = cc.x;
        			tuple[3] = cc.y;
        			Arrays.sort(tuple);
        			
        			List<Integer> tu = new ArrayList<Integer>();
        			for(int i : tuple)
        				tu.add(i);
        			result.add(tu);
        		}
        	}
        	
        }
        
        Set<List<Integer>> set = new HashSet<List<Integer>>(result);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.addAll(set);
        return list;
    }
	
}
