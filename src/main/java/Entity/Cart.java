package Entity;

public class Cart {
	private int id;
	private Product p;
	private int count;
	private int totalprice;
	
	public Cart() {
		super();
	}

	public Cart(int id, Product p, int count, int totalprice) {
		super();
		this.id = id;
		this.p = p;
		this.count = count;
		this.totalprice = totalprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Cart [id=" + id + ", p=" + p + ", count=" + count + ", totalprice=" + totalprice + "]";
	}
	
}