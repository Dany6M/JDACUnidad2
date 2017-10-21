package utng.model;

import java.io.Serializable;

public class Location implements Serializable{
	private String id;
	private String parentId;
	private String type;
	private String name;
	private int code;
	
	public Location() {
		this("","","","",0);
	}

	public Location(String id, String parentId, String type, String name, int code) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.type = type;
		this.name = name;
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", parentId=" + parentId + ", type=" + type + ", name=" + name + ", code=" + code
				+ "]";
	}
	
	
	
	

}
