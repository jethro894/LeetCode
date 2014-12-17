package com.leet.supph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
		//System.out.println(delimiter);
		
		//get the indices of columns we want
		verifyColumnIndex();
		
		//read the file line by line, we assume 
		if(this.quantity_col_index == -1 || this.product_ID_col_index == -1)
			return;
		
		try {
			FileInputStream fis = new FileInputStream(inventory_file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			String line = null;
			while ((line = br.readLine()) != null) {
			    // Deal with the line, split using delimiter and feed the resultant string array into generateEntry() defined in parent class
				// this method will convert the array into formatted table entries if the indices are set
				StringTokenizer st = new StringTokenizer(line, delimiter);
				List<String> tokens = new ArrayList<String>();
				while(st.hasMoreTokens())
					tokens.add(st.nextToken());
				generateEntry(tokens);
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
	//each time I start parsing a file I will find indices in a specific table that stores the configurations
	//if it is found, then I use those indices
	//otherwise I would assume that there are titles in the file
	//then I will parse the titles to find the indices, and store the indices in the database
	@Override
	protected void verifyColumnIndex(){
		//must set product_ID_col_index and quantity_col_index in this method!
		DatabaseManager dm = DatabaseManager.getDM();
		int[] indices = dm.findIndices(supplier_ID);
		if(indices != null && indices.length >= 2){
			this.product_ID_col_index = indices[0];
			this.quantity_col_index = indices[1];
		}
			
		if(product_ID_col_index != -1 && quantity_col_index != -1)
			return;
		
		//indices not found, parse the title row
		FileInputStream fis;
		try {
			fis = new FileInputStream(inventory_file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			String line1 = br.readLine();
			
			StringTokenizer st = new StringTokenizer(line1, delimiter);
			List<String> tokens = new ArrayList<String>();
			while(st.hasMoreTokens())
				tokens.add(st.nextToken());
			
			for(int i = 0; i < tokens.size(); i++){
				String cur = tokens.get(i).toLowerCase();
				if(cur.equals("product") || cur.equals("product_id") || cur.equals("product id"))
					this.product_ID_col_index = i;
				else if(cur.equals("quantity") || cur.equals("inventory"))
					this.quantity_col_index = i;
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("pid = " +  product_ID_col_index + ", quantity = " + quantity_col_index);
		dm.saveIndices(supplier_ID, product_ID_col_index, quantity_col_index);
	}
	
}
