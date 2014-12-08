package com.leet.zill;
/*
 * A String to Long Java program
 * 		-	takes an input number string s from -9223372036854775808 to 9223372036854775807, and convert it into Long number
 * 		-	any number outside the [-9223372036854775808, 9223372036854775807] interval will be considered invalid and cause an exception
 * 		-	any non-digit character in the string, except for the leading minus sign, will be considered invalid and cause an exception
 * 		-	leading and trailing whitespaces will be stripped
 * 		-	takes at most O(2*n) = O(n) time where n is the length of s	
 * weak points:
 * 		-	doesn't support scientific notation (e.g. 2.99792458e8)
 * 		-	doesn't support other bases other than decimal
 * 		-	many special cases, looks 	
 */
public class StringToLong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringToLong().stringToLong("9223372035854775806"));
	}
	
	public long stringToLong(String s){
		s = s.trim();
		if(s.length() == 0)
			return 0;
		
		int valid;
		boolean neg = false;
		if(s.charAt(0)=='-'){
			String min = ("" + Long.MIN_VALUE).substring(1);
			valid = -largerThanMax(s.substring(1), min);
			neg = true;
		}
		else{
			String max = ""+Long.MAX_VALUE;
			valid = -largerThanMax(s, max);
		}
		
		if(valid < 0)
			throw new NumberFormatException();
		else if(valid == 0){
			if(neg)
				return Long.MIN_VALUE;
			else
				return Long.MAX_VALUE;
		}else{
			int index = 0;
			if(neg)
				index = 1;
			
			long result = 0;
			while(index<s.length()){
				if(s.charAt(index)<'0' || s.charAt(index)>'9')
					throw new NumberFormatException();
				result = result*10+(s.charAt(index)-'0');
				index++;
			}
			
			//flipping the result won't cause overflow 
			//because the edge case (flip from invalid 9223372036854775808 to valid -9223372036854775808) has already been processed
			if(neg)
				return -result;
			else
				return result;
		}
	}
	
	/*
	* compare the length of string with the max number in long
	*		-	if shorter, return -1, meaning that it won't overflow
	*		-	if longer, return 1, meaning that it must overflow
	*		-	if same length, iteratively compare the digits
	*		-	if totally the same, return 0, meaning that it is identical to the max number
	*max could be Long.MAX_VALUE or -Long.MIN_VALUE
	*whether there is a leading '-' sign in s decides which max value to compare
	*/
	private int largerThanMax(String s, String max){
		if(s.length() == 0)
			return -1;

		if (s.length() < max.length())
			return -1;
		else if (s.length() > max.length())
			return 1;
		else{
			int index = 0;
			while(index < s.length()){
				if(s.charAt(index)<'0' || s.charAt(index)>'9')
					return 1;

				if(s.charAt(index) < max.charAt(index))
					return -1;
				else if(s.charAt(index) > max.charAt(index))
					return 1;
				else
					index++;
			}
			return 0;
		}
	}
}
