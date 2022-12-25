package Entity;

import java.sql.Date;
import java.util.List;

public class Order {
	private String name;
	private String phone;
	private String address;
	private List<OrderDetails> listOrder;
	private int total;
	private Date createdDate;
	
	public Order() {
		super();
	}

	public Order(String name, String phone, String address, List<OrderDetails> listOrder, int total,
			Date createdDate) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.listOrder = listOrder;
		this.total = total;
		this.createdDate = createdDate;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderDetails> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<OrderDetails> listOrder) {
		this.listOrder = listOrder;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Order [name=" + name + ", phone=" + phone + ", address=" + address + ", listOrder=" + listOrder
				+ ", total=" + total + ", createdDate=" + createdDate + "]";
	}
}
