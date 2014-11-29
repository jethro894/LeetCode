package com.leet;

public class ZigZagConversion {
	public static void main(String[] args){
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 2));
	}
	
	public String convert(String s, int nRows) {
        if(s.length() == 0 || nRows <= 0)
        	return "";
        
        if(nRows == 1)
        	return s;
        
        int block_size = 2*nRows-2;
        int block_num = s.length()/block_size+1;
        
        char[][] zigzag = new char[nRows][2*block_num];
        
        int k = 0;
        for(int j = 0; j < 2*block_num; j++){
        	if(j % 2 == 0){
        		for(int i = 0; i < nRows; i++){
        			if(k < s.length()){
        				zigzag[i][j] = s.charAt(k);
                    	k++;
        			}
            	}
        	}
        	else{
        		for(int i = nRows -2; i > 0; i--){
        			if(k < s.length()){
        				zigzag[i][j] = s.charAt(k);
                    	k++;
        			}
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < zigzag.length; i++){
        	for(int j = 0; j < zigzag[0].length; j++){
        		System.out.print(zigzag[i][j] + " ");
        		if(zigzag[i][j] != 0)
        			sb.append(zigzag[i][j]);
        	}
        	System.out.println();
        }
        
        return sb.toString();
    }
}
