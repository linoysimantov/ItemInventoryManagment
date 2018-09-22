package com.linoy.inventoryWebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Parameter;




@Entity
@Table(name = "items")
public class Item {
	
	@Id
//	@org.hibernate.annotations.GenericGenerator(
//		    name="Question_id_sequence", 
//		    strategy = "sequence", 
//		    parameters = { 
//		        @Parameter(name="sequence", value="S_QUESTION") 
//		    })
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "items_generator")
	@TableGenerator(name = "items_generator", initialValue = 1, allocationSize = 1)
	private long id;
	  
	@Column(name = "itemName")
	private String itemName;
	
	  @Column(name = "inventoryCode")
	private long inventoryCode;
	
	  @Column(name = "amount")
	private int amount;

	public Item() {}     
	public Item( long id, String itemName, long inventoryCode, int amount) {
		super();
		this.id = id;
		this.inventoryCode = inventoryCode;
		this.amount = amount;
		this.itemName = itemName;

	}
	public Item( String itemName, long inventoryCode, int amount) {
		super();
		this.inventoryCode = inventoryCode;
		this.amount = amount;
		this.itemName = itemName;

	}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(long inventoryCode) {
		this.inventoryCode = inventoryCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", inventoryCode=" + inventoryCode + ", amount=" + amount
				+ "]";
	}
	
	
}
