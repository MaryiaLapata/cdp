package com.epam.cdp.userManagement.model;

public class Permission {

	private long id;
	private String object;
	private byte actionType;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public byte getActionType() {
		return actionType;
	}
	public void setActionType(byte actionType) {
		this.actionType = actionType;
	}	
}
