package com.leet.supph;

import java.util.HashSet;
import java.util.Set;

/*
 * This java program draws a supplyhouse swoosh logo in the console
 * The perfect approach is to obtain the math expression of ellipses, then convert into pixels
 * It is tricky to do it, since it may involve swing or awt classes
 * 
 * I have learned image processing in my undergraduate college
 * My basic idea is to zoom a sample logo to a new resolution
 * The sample logo I am using is the 16*8 logo from the problem set
 * for width <= 27, the simple nearest neighbor interpolation works well
 * for larger width, the resultant grid looks mosaic. To obtain better result, I have two choices:
 * 		1. bilinear interpolation
 * 		2. image smoothing
 * 
 * I have tried bilinear interpolation, and the result is not very promising for binary pixels. It still looks mosaic.
 * Finally I choose to smooth the image, this will result in higher time complexity. (still O(n^2) if we choose constant mask size)
 * But I have chosen scaling factor dependent mask size to obtain better result
 * This is because I assume that image processing will not have arbitraty large input 
 * After all most of modern computer monitors only have 1920 pixels for width 
 * 
 * There are some optimizations that are specially designed for this logo, in order to obtain better result
 * Most of them are obtained through tests
 * I will highlight the optimizations in the comments of codes
 */

public class GenerateSwoosh {
	
	//main test function
	public static void main(String[] args){
		new GenerateSwoosh().drawSwoosh(90);
	}
	
	//function required
	public void drawSwoosh(int width){
		
		/*avoid invalid inputs
		*from experiment, the min width to generate a grid with non-space pixels is 3
		*the min width to generated a human-distinguishable swoosh is 5
		*/
		if(width < 1)
			return;
		
		//simply set the height to be half of width
		int height = (width+1)/2;
		char[][] swoosh = new char[height][width];
		
		//generate the sample swoosh with width = 16
		int sample_width = 16;
		char[][] sample_16 = initializeSample();
		
		//opmization 1: some rows must be filled up with non-space pixels to make the logo look intact
		//pixels in these rows will not be flipped into whitespace in image smoothing
		Set<Integer> full_rows = new HashSet<Integer>();
		
		//simple nearest neighbor interpolation, works fine for width <= 27 with no sense of mosaic
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				//translate the new coordinates into old coordinates in sample swoosh
				double row = (double)i/(double)(height-1)*(double)(sample_width/2-1);
				double col = (double)j/(double)(width-1)*(double)(sample_width-1);
				
				//round to the integer coordinate in sample swoosh
				int row_round = (int)Math.round(row);
				int col_round = (int)Math.round(col);
				
				//if rounded to the full row, which is the 3rd row in sample, log it down
				if(row_round == 2)
					full_rows.add(i);
				
				//simply take the value of nearest neighbor
				swoosh[i][j] = sample_16[row_round][col_round];
			}
		}
		
		/*optimization 2: for larger width, the simple nearest neighbor approach generates mosaics
		*we use the moving average method to smooth the grid
		*we use a 2-d mask to calculate the moving average
		*/ 
		if(width >= 28){
			//get the best dimension of the n*n 2-d mask
			//optimization 3: best dimension is related to the scaling factor width/sample_width
			//2*mask_dim + 1 is the length of the side of the mask
			int mask_dim = (double)width/(double)sample_width-width/sample_width >= 0.5? width/sample_width+1 : width/sample_width;
			smooth(swoosh, mask_dim, full_rows);
		}
		//print out the result
		print(swoosh);
	}
	
	//hard-coded sample swoosh with sample_width = 16 and sample_height = 8
	public char[][] initializeSample(){
		char[][] sample = new char[8][16];
		for(int i = 0; i < 8; i++){
			if(i==0){
				int j = 0;
				while(j < 16){
					if(j <= 2 || j >= 13)
						sample[i][j] = ' ';
					else 
						sample[i][j] = 'x';
					j++;
				}
			}
			else if(i==1){
				int j = 0;
				while(j < 16){
					if(j == 0 || j == 15)
						sample[i][j] = ' ';
					else 
						sample[i][j] = 'x';
					j++;
				}
			}
			else if(i==2){
				int j = 0;
				while(j < 16){
						sample[i][j] = 'x';
						j++;
				}
			}
			else if(i==3){
				int j = 0;
				while(j < 16){
					if(j >= 12)
						sample[i][j] = ' ';
					else 
						sample[i][j] = 'x';
					j++;
				}
			}
			else if(i==4){
				int j = 0;
				while(j < 16){
					if(j >= 8)
						sample[i][j] = ' ';
					else 
						sample[i][j] = 'x';
					j++;
				}
			}
			else if(i==5){
				int j = 0;
				while(j < 16){
					if(j >= 6)
						sample[i][j] = ' ';
					else 
						sample[i][j] = 'x';
					j++;
				}
			}
			else if(i==6){
				int j = 0;
				while(j < 16){
					if(j == 0 || j >= 7)
						sample[i][j] = ' ';
					else 
						sample[i][j] = 'x';
					j++;
				}
			}
			else{
				int j = 0;
				while(j < 16){
					if(j <= 2 || j >= 8)
						sample[i][j] = ' ';
					else 
						sample[i][j] = 'x';
					j++;
				}
			}
		}
		return sample;
	}

	/*to smooth a pixel, we check the pixels around it within the mask
	*then we set a threshold (0.5) to decide the center pixel by examing the average of other pixels in the mask
	* one drawback is that the result of smoothing is decided by the sequence of visiting the pixels
	*/
	public void smooth(char[][] image, int mask_dim, Set<Integer> full){
		//image does not need to be smoothed
		if(mask_dim < 1)
			return;
		
		//optimization 4: start from the lower right corner of the image, since the lower part is "craned out", and is very vulnerable if we don't treat it first
		//optimization 5: since the last few rows are craned out, the moving average method will definitely wipe them, so we skip the last 2 rows to preserve the pinpoint
		for(int i = image.length-3; i >= 0; i--)
			//smooth the pixels if they are not in the full row
			if(!full.contains(i))
				for(int j = image[0].length-1; j >= 0 ; j--){
					int sum = 0;
					
					//sum up the pixels in the mask from (i-mask_dim, j-mask_dim) to (i+mask_dim, j+mask_dim)
					for(int m = i - mask_dim; m <= i + mask_dim; m++)
						for(int n = j - mask_dim; n <= j + mask_dim; n++)
							//exclude the center pixel
							if(m != i && n != j)
								//if part of the mask is out of the image, treat it as whitespace
								if(m >= 0 && n >= 0 && m < image.length && n < image[0].length){
									//sum++ if the pixel is not whitespace
									if(image[m][n]!=' ')
										sum++;
								}
						
					//decide the content of center pixel
					if(sum > ((2*mask_dim)*(2*mask_dim)-1)/2)
							image[i][j] = 'x';
					else
							image[i][j] = ' ';
				}
	}
	
	//print out the 2-d char array
	public void print(char[][] image){
		for(int i = 0; i < image.length; i++){
			for(int j = 0; j < image[0].length; j++)
				System.out.print(image[i][j]+" ");
			System.out.println();
		}
	}
}
