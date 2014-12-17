package com.leet.supph;

/*
 * An entry that contains only the information needed to insert into/update the database table
 * The methods in the database driver is designed with this type of input
 */
public class InventoryEntry {
	String product_id;
	String supplier_id;
	int quantity;
	
	public InventoryEntry(String product_id, String supplier_id, int quantity) {
		this.product_id = product_id;
		this.supplier_id = supplier_id;
		this.quantity = quantity;
	}
}
