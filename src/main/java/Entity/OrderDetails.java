package Entity;

public class OrderDetails {
	private int id;
	private int orderId;
	private Product p;
	private int count;
	private int totalprice;
	private int status;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(int id, int orderId, Product p, int count, int totalprice, int status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.p = p;
		this.count = count;
		this.totalprice = totalprice;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", p=" + p + ", count=" + count + ", totalprice="
				+ totalprice + ", status=" + status + "]";
	}
	
}
