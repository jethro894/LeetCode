package com.leet.supph;

import java.io.File;
import java.util.List;

/*
 * InventoryFileParser: the abstract class of file parser
 * contains universal attributes and method definitions
 * for methods that are different in different sub-classes(e.g. startParsing() and verifyColumnIndex()), only define an abstract method
 * for unisersal methods, we directly implement them here
 */
public abstract class InventoryFileParser {
	File inventory_file;			//the file to be parsed
	String supplier_ID = null;		//supplier ID, which should be the filename with extensions stripped
	int product_ID_col_index = -1;	//the column index of product IDs, can be obtained through verifyColumnIndex()
	int quantity_col_index = -1;	//the column index of quantities, can be obtained through verifyColumnIndex()
	boolean job_completed = false;	//indicate whether this parsing job is completed, if the startParsing() exits without set this flag, there may be exceptions thrown in parsing
	List<InventoryEntry> entries;	//contains formated entries directly feedable to the database. We assume the server memory is large enough to contain all the entries
	
	//actual parsing method differs in plain text parser and excel parser
	abstract public void startParsing();
	
	//actual column index identification method differs in different parsers
	abstract protected void verifyColumnIndex();

	//unisersal method to save inventory entries to database
	public void saveToDB(DatabaseManager dm, String table_name){
		//if job_completed flag is not set, theres is something wrong in parsing and we won't save the records
		if(!job_completed)
			return;
		for(InventoryEntry ie : entries){
			dm.save(ie, table_name);
		}
	}
	
	//if the column indexes of product ID and quantity are confirmed, feeding a tokinized line to this method will generate and save a formatted entry
	protected void generateEntry(String[] line_tokens) throws Exception{
		if(product_ID_col_index == -1 || quantity_col_index == -1 || supplier_ID == null)
			return;
		
		InventoryEntry ie = new InventoryEntry(line_tokens[product_ID_col_index], 
				supplier_ID, 
				Integer.parseInt(line_tokens[quantity_col_index]));
		entries.add(ie);
	}
}
