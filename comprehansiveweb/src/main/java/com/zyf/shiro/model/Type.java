package com.zyf.shiro.model;

public class Type {
	private int typeId;
	private String type;
	private String typeName;
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Type() {
		super();
	}
	public Type(int typeId, String type, String typeName) {
		super();
		this.typeId = typeId;
		this.type = type;
		this.typeName = typeName;
	}
	
	
}
