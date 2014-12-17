package com.leet.supph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Pattern;

/*
 * PlainTextInventoryFileParser: special customed to parse plain txt files (txt and csv)
 * overides some methods in InventoryFileParser
 */
public class PlainTextInventoryFileParser extends InventoryFileParser{
	String delimiter;	//specified the delimiter, we assume "\t" in txt files and "," in csv files
	
	//constructor
	public PlainTextInventoryFileParser(File f, String del){
		this.inventory_file = f;
		this.delimiter = del;
		this.supplier_ID = this.inventory_file.getName().replaceFirst("[.][^.]+$", "");
		this.entries = new ArrayList<InventoryEntry>();
	}
	
	//actual parsing method, takes the delimiter to tokenize a line
	@Override
	public void startParsing(){
		System.out.println(inventory_file.getName());
		System.out.println(delimiter);
		
		//get the indices of columns we want
		verifyColumnIndex();
		
		//read the file line by line, we assume 
		try {
			FileInputStream fis = new FileInputStream(inventory_file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			String line = null;
			while ((line = br.readLine()) != null) {
			    // Deal with the line, split using delimiter and feed the resultant string array into generateEntry() defined in parent class
				// this method will convert the array into formatted table entries if the indices are set
				generateEntry(line.split(Pattern.quote(delimiter)));
			}
			
			br.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//when parsing complete, set the flag
		this.job_completed = true;
	}
	
	
	//see which column is product ID, and which column is quantity
	//then set product_ID_col_index and quantity_col_index
	//not very clear about how this can be done, check uniqueness of product ID and valid integer could be one approach, but it is very inefficient
	//it's better to have a pre-determined schema, or the first line with column title
	@Override
	protected void verifyColumnIndex(){
		//must set product_ID_col_index and quantity_col_index in this method!
	}
	
}
