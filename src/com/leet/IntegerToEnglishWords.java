package com.leet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToEnglishWords {

	static Map<Integer, String> largeUnits = new LinkedHashMap<Integer, String>();
	static{
		largeUnits.put(1000000000, "Billion ");
		largeUnits.put(1000000, "Million ");
		largeUnits.put(1000, "Thousand ");
	}
	
	static Map<Integer, String> smallUnits = new LinkedHashMap<Integer, String>();
	static{
		smallUnits.put(100, "Hundred ");
		smallUnits.put(90, "Ninety ");
		smallUnits.put(80, "Eighty ");
		smallUnits.put(70, "Seventy ");
		smallUnits.put(60, "Sixty ");
		smallUnits.put(50, "Fifty ");
		smallUnits.put(40, "Fourty ");
		smallUnits.put(30, "Thirty ");
		smallUnits.put(20, "Twenty ");
		
	}
	
	static Map<Integer, String> under20 = new HashMap<Integer, String>();
	static{
		under20.put(19, "Nineteen ");
		under20.put(18, "Eighteen ");
		under20.put(17, "Seventeen ");
		under20.put(16, "Sixteen ");
		under20.put(15, "Fifteen ");
		under20.put(14, "Fourteen ");
		under20.put(13, "Thirteen ");
		under20.put(12, "Twelve ");
		under20.put(11, "Eleven ");
		under20.put(10, "Ten ");
	}
	
	static Map<Integer, String> under10 = new HashMap<Integer, String>();
	static{
		under10.put(9, "Nine ");
		under10.put(8, "Eight ");
		under10.put(7, "Seven ");
		under10.put(6, "Six ");
		under10.put(5, "Five ");
		under10.put(4, "Four ");
		under10.put(3, "Three ");
		under10.put(2, "Two ");
		under10.put(1, "One ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 20;
		System.out.println(new IntegerToEnglishWords().numberToWords(num));
	}
	
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        
        if(num == 0){
        	return "Zero";
        }else if(num < 0){
        	sb.append("Minus ");
        	num = -num;
        }
        
        for(Map.Entry<Integer, String> entry : largeUnits.entrySet()){
        	int unit = entry.getKey();
        	String name = entry.getValue();
        	
        	int quantity = num/unit;
        	System.out.println("Scale: " + name + ", qty: " + quantity);
        	if(quantity > 0){
        		sb.append(underThousand(quantity));
        		sb.append(name);
        		num -= quantity*unit;
        	}
        }
        
        sb.append(underThousand(num));
        
        return sb.toString().trim();
    }
    
    public String underThousand(int num){
    	System.out.println("input: " + num);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	int hundreds = num/100;
    	if(hundreds > 0){
    		sb.append(under10.get(hundreds));
    		sb.append("Hundred ");
    		num -= hundreds*100;
    	}
    	
    	//21~99
    	for(Map.Entry<Integer, String> entry : smallUnits.entrySet()){
    		if(num < 20){
    			break;
    		}
    		
			int unit = entry.getKey();
        	String name = entry.getValue();
        	
        	int quantity = num/unit;
        	if(quantity > 0){
        		sb.append(name);
        		num -= quantity*unit;
        	}
		}
    	
    	System.out.println(num);
    	
    	if(num > 0){
    		if(num < 10){
        		sb.append(under10.get(num));
        	}else if(num < 20){
        		sb.append(under20.get(num));
        	}
    	}

    	return sb.toString();
    }

}
