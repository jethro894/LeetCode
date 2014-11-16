package com.leet;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0)
        	return null;
        
        if(num1.length() < num2.length())
        	return multiply(num2, num1);
        
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        
        for(int i = 0; i < n1.length; i++){
        	n1[i] = charToDigit(num1.charAt(n1.length - i - 1));
        	if(n1[i] > 9 || n1[i] < 0)
        		return null;
        }
        for(int j = 0; j < n2.length; j++){
        	n2[j] = charToDigit(num2.charAt(n2.length - j - 1));
        	if(n2[j] > 9 || n1[j] < 0)
        		return null;
        }
        
        String[] eachDigitMultiply = new String[n2.length];
        
        for(int i = 0; i < n2.length; i++){
        	int product = 0;
            int carry = 0;
            StringBuilder thisDigitMultiply =  new StringBuilder();
            for(int j = 0; j < n1.length; j++){
            	product = n2[i]*n1[j] + carry;
            	carry = product/10;
            	thisDigitMultiply.append(product%10);
            }
            if(carry > 0)
            	thisDigitMultiply.append(carry);
            
            for(int k = 0; k < i; k++){
            	thisDigitMultiply.insert(0, 0);
            }
            eachDigitMultiply[i] = thisDigitMultiply.toString();
        }

        StringBuilder sb = new StringBuilder();
        
        int sum = 0;
    	int carry = 0;
    	
        for(int i = 0; i < eachDigitMultiply[eachDigitMultiply.length - 1].length(); i++){
        	
        	for(int j = 0; j < eachDigitMultiply.length; j++){
        		if(i < eachDigitMultiply[j].length())
        			sum += charToDigit(eachDigitMultiply[j].charAt(i));	
        	}
        	sum += carry;
        	carry = sum/10;
        	sb.append(sum%10);
        	sum = 0;
        }
        if(carry > 0)
        	sb.append(carry);
        
        sb = sb.reverse();
        String raw = sb.toString();
        int i = -1;
        for(i = 0; i < raw.length(); i++){
        	if(raw.charAt(i) != '0')
        		break;
        }
        
        if(i == raw.length())
        	return "0";
        else
        	return sb.substring(i);

    }
	
	public int charToDigit(char c){
		return (int)(c-'0');
	}
	
}
