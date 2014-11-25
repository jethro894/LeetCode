package com.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        
        if(intervals.size() == 0)
        	return list;
        
        Comparator<Interval> comp_itv = new Comparator<Interval>(){

			@Override
			public int compare(Interval arg0, Interval arg1) {
				// TODO Auto-generated method stub
				if(arg0.start != arg1.start)
					return arg0.start - arg1.start;
				return arg0.end - arg1.end;
			}
        	
        };
        
        Collections.sort(intervals, comp_itv);
        
        list.add(intervals.get(0));
        for(Interval i : intervals){
        	if(i.start <= list.get(list.size()-1).end){
        		int later = Math.max(list.get(list.size()-1).end, i.end);
        		list.get(list.size()-1).end = later;
        	}else
        		list.add(i);
        }
        return list;
    }
}
