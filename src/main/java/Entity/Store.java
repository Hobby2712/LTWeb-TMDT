package Entity;

import java.sql.Date;

public class Store {
	private int id;
	private String name;
	private int ownerId;
	private Date createdDate;
	private int isActive;

	public Store(int id, String name, int ownerId, Date createdDate, int isActive) {
		super();
		this.id = id;
		this.name = name;
		this.ownerId = ownerId;
		this.createdDate = createdDate;
		this.isActive = isActive;
	}

	public Store() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}