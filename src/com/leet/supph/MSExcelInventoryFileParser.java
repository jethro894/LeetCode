package com.leet.supph;

import java.io.File;
import java.util.ArrayList;

/*
 * MSExcelInventoryFileParser: special customed to parse excel files (xls and xlsx)
 * overides some methods in InventoryFileParser
 * very similar to PlainTextInventoryFileParser
 * some third-party API is needed, such as Apache POI
 */
public class MSExcelInventoryFileParser extends InventoryFileParser{
	boolean legacy;	//if set, indicates that the file is the Excel 97~2003 .xls file, otherwise it is a newer .xlsx file
	
	//constructor
	public MSExcelInventoryFileParser(File f, boolean lega){
		this.inventory_file = f;
		this.legacy = lega;
		this.supplier_ID = this.inventory_file.getName().replaceFirst("[.][^.]+$", "");
		this.entries = new ArrayList<InventoryEntry>();
	}
	
	//actual parsing method, tokenize a line using some build-in functions
	@Override
	public void startParsing(){
		System.out.println(inventory_file.getName());
		System.out.println(legacy);
		
		//get the indices of columns we want
		verifyColumnIndex();
		
		/*
		 * get the rows and parse them into String[] array and feed into generateEntry() defined in parent class
		 * actual codes are not implemented here
		 * we may need two blocks of codes to deal with xls and xlsx files
		 */

		//when parsing complete, set the flag
		this.job_completed = true;
	}
	
	//see which column is product ID, and which column is quantity
	//set product_ID_col_index and quantity_col_index
	//in excel file, this can be easier since there are built-in methods to efficient make some basic queries provided by the API
	@Override
	protected void verifyColumnIndex(){
		//must set product_ID_col_index and quantity_col_index in this method!
	}
}
