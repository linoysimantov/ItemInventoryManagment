package com.linoy.inventoryWebApp.exception;

public class ItemException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param msg
	 */
	public ItemException (String msg) {
		super (msg);
	}
	/**
	 * 
	 * @param desc
	 * @param throwable
	 */
	public ItemException (String desc , Throwable throwable)
	{
		super (desc , throwable);
	}

}
