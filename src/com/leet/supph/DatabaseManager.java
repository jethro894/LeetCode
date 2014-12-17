package com.leet.supph;

/*
 * The database manager and driver layer
 * uses singleton pattern to eliminate concurrency issues
 * takes only the InventoryEntry instance to save a record into a specified table
 */

/*
 * the table should be similar to:
 * {
 * 		SUPPLIER_ID VARCHAR(63) NOT NULL,
 * 		PRODUCT_ID VARCHAR(63) FOREIGN KEY REFERENCES PRODUCT(PRODUCT_ID),
 * 		QUANTITY int NOT NULL,
 * 		CONSTRAINT pk_INVENTORY_ID PRIMARY KEY (SUPPLIER_ID,PRODUCT_ID)
 * }
 * 
 * the table that contains supplier file formats must at least look like
 * {
 * 		SUPPLIER_ID varchar(64) NOT NULL,
 * 		PID_INDEX int NOT NULL,
 * 		QTY_INDEX int NOT NULL,
 * 		PRIMARY KEY (SUPPLIER_ID)
 * } 
 */
public class DatabaseManager {
	//JDBC or other driver, singleton pattern
	
	public static volatile DatabaseManager instance = null;
	
	//private final String username = "blabla";
	//private final String password = "blabla";
	//private final String default_database = "blabla";
	//private final String default_table_name = "blabla";
	//private final String confgig_table_name = "blabla";
	//private Connection connection = null;
	
	//constructor
	private DatabaseManager(){
		//Connection = connect();
	}
	
	//facade
	synchronized public static DatabaseManager getDM(){
		if(instance == null)
			instance =  new DatabaseManager();
		return instance;
	}
	
	synchronized protected int[] findIndices(String supplier_ID){
		//use a dedicated table, here we assume table_name = "supplier_indices"
		//if product_id == true, return index of product_id, ow return index of quantity
		//if found, return index[]
		return null;
	}
	
	synchronized protected boolean saveIndices(String supplier_ID, int product_index, int quantity_index){
		//use a dedicated table, here we assume table_name = "supplier_indices"
		//if(this.connection == null)(connection = connect();)
		//if failed, return false
		
				//if success
				return true;
	}
	
	//private Connection connect(){}
	
	//locked method to insert/update an entry into the table
	//returns whether the actions is completed successfully
	synchronized public boolean save(InventoryEntry ie, String table_name){
		//if(this.connection == null)(connection = connect();)
		//should be upsert
		
		//if failed, return false
		
		//if success
		return true;
	}
	
	public void close(){
		//connection.close();
		instance = null;
	}
}
