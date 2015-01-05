package com.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
        if(version1.length() == 0 || version2.length() == 0)
        	return 0;
        
        StringTokenizer st1 = new StringTokenizer(version1, ".");
        List<Integer> version1s = new ArrayList<Integer>();
        while(st1.hasMoreTokens()){
        	version1s.add(Integer.parseInt(st1.nextToken()));
        }
        
        StringTokenizer st2 = new StringTokenizer(version2, ".");
        List<Integer> version2s = new ArrayList<Integer>();
        while(st2.hasMoreTokens()){
        	version2s.add(Integer.parseInt(st2.nextToken()));
        }
        
        int i = 0;
        while(i < version1s.size() && i < version2s.size()){
        	if(version1s.get(i)<version2s.get(i))
        		return -1;
        	else if(version1s.get(i)>version2s.get(i))
        		return 1;
        	else
        		i++;
        }
        
        if(i < version1s.size()){
        	Set<Integer> set = new HashSet<Integer>(version1s.subList(i, version1s.size()));
        	if(set.size() == 1 && set.contains(0))
        		return 0;
        	return 1;
        }
        	
        if(i < version2s.size()){
        	Set<Integer> set = new HashSet<Integer>(version2s.subList(i, version2s.size()));
        	if(set.size() == 1 && set.contains(0))
        		return 0;
            return -1;
        }
        	
        return 0;
    }
}
