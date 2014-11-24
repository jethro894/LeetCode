package com.leet;

import java.util.HashMap;

public class IntegerToRoman {
	public static void main(String[] args){
		System.out.println(new IntegerToRoman().intToRoman(1999));
	}
	public String intToRoman(int num) {
        if(num < 1 || num > 3999)
        	return null;
        
        HashMap<Integer, String> dic = generateDictionary();
        
        StringBuilder sb = new StringBuilder();
        int remainder = num;
        
        for(int i = 0; i < 4; i++){
        	int power = (int) Math.pow(10, i+1);
        	
        	int residue = remainder%power;
        	int mod = residue/(power/10);
        	//System.out.println("power: " + power + ", remainder: " + remainder + ", residue: " + residue + ",mod: " + mod);
        	if(mod == 5)
        		sb.append(dic.get(5*(power/10)));
        	else{
        		if(mod < 5){
        			if(mod == 4){
        				sb.append(dic.get(5*(power/10)));
        				sb.append(dic.get(power/10));
        			}else{
        				for(int j = 0; j < mod; j++)
        					sb.append(dic.get(power/10));
        			}
        		}else{
        			if(mod == 9){
        				sb.append(dic.get(power));
        				sb.append(dic.get(power/10));
        			}else{
        				for(int j = 0; j < mod - 5; j++)
        					sb.append(dic.get(power/10));
        				sb.append(dic.get(5*(power/10)));
        			}
        		}
        	}
        	remainder = remainder-residue;
        }

        return sb.reverse().toString();
    }
	
	public HashMap<Integer, String> generateDictionary(){
		HashMap<Integer, String> dic = new HashMap<Integer, String>();
        dic.put(1, "I");
        dic.put(5, "V");
        dic.put(10, "X");
        dic.put(50, "L");
        dic.put(100, "C");
        dic.put(500, "D");
        dic.put(1000, "M");
        return dic;
	}
}
