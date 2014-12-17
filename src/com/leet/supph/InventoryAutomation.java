package com.leet.supph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * Java package that does the automated job described in Problem 3
 * package includes but not limited to:
 * 		InventoryAutomation.java - the main entrance of the program
 * 		InventoryFileParser.java - the abstract class of file parser
 * 			PlainTextInventoryFileParser.java - inherited from IntentoryFileParser, used if plain text files(.txt, .csv) detected
 * 			MSExcelInventoryFileParser.java   - inherited from IntentoryFileParser, used if ms excel files(.xls, .xlsx) detected
 * 		InventoryEntry.java - The data structure that contains an entry in table SUPPLIER_PRODUCT
 * 		DatabaseManager.java - The database driver to actually inserts into/updates the database
 */

/*
 * InventoryAutomation: the automated work flow to:
 * 		- check files in the specified directory
 * 		- classify files into different parsers
 * 		- for each parser, the main program does the following jobs:
 * 			- call methods in the parsers to obtain database entry instances
 * 			- save the entry into database through a database driver
 * 		
 * If we want to schedule the program to work daily, it is better to be scheduled using tools provided by OS
 */
public class InventoryAutomation {
	
	/*
	 * main entrace, takes an argument to find the directory
	 * otherwise use the default folder "data/" under the working directory
	 */
	public static void main(String[] args){
		String dir = null;
		if(args.length < 1)
			dir = "data/";
		else
			dir = args[0];
		
		//return if dir is not a directory
		File folder = new File(dir);
		if(!folder.isDirectory())
			return;
		
		//list files in the folder and prepare a container to contain parsers
		File[] file_list = folder.listFiles();
		List<InventoryFileParser> container = new ArrayList<InventoryFileParser>();
		
		//classify files and assign proper parser to the file
		//we support only 4 types of files: plain text, comma separated, and two MS Excel files (xls or xlsx)
		//we assume txt files are tab delimited
		for(File f : file_list){
			if(f.getName().endsWith(".txt")){
				PlainTextInventoryFileParser ptifp = new PlainTextInventoryFileParser(f,"\t");
				container.add(ptifp);
			}
			if(f.getName().endsWith(".csv")){
				PlainTextInventoryFileParser ptifp = new PlainTextInventoryFileParser(f,",");
				container.add(ptifp);
			}
			if(f.getName().endsWith(".xls")){
				MSExcelInventoryFileParser mseifp = new MSExcelInventoryFileParser(f,true);
				container.add(mseifp);
			}
			if(f.getName().endsWith(".xlsx")){
				MSExcelInventoryFileParser mseifp = new MSExcelInventoryFileParser(f,false);
				container.add(mseifp);
			}
		}
		
		//for each parser, parser the file and same the parsed result into database
		DatabaseManager dm = DatabaseManager.getDM();
		String table_name = args.length > 1? args[1] : "SUPPLIER_PRODUCT";
		for(InventoryFileParser ifp : container){
			ifp.startParsing();
			for(InventoryEntry ie : ifp.entries){
				System.out.println(ie.supplier_id + ", " + ie.product_id + ", " + ie.quantity);
			}
			ifp.saveToDB(dm, table_name);
		}
		
		//close the database connection
		dm.close();
	}
}
