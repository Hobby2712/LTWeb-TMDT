package Entity;

import java.text.NumberFormat;
import java.util.Locale;

public class Product {
	private int id;
	private String name;
	private int price;
	private String image;
	private String description;
	private int quantity;
	private int cateId;
	private int storeId;
	private int sold;	

	public Product() {
		super();
	}

	public Product(int id, String name, int price, String image, String description, int quantity, int cateId,
			int storeId, int sold) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.description = description;
		this.quantity = quantity;
		this.cateId = cateId;
		this.storeId = storeId;
		this.sold = sold;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	
	
	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	public int getSold() {
		return sold;
	}


	public void setSold(int sold) {
		this.sold = sold;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", description="
				+ description + ", quantity=" + quantity + ", cateId=" + cateId + ", storeId=" + storeId + ", sold="
				+ sold + "]";
	}


	public String tienTe(int price) {
    	Locale localeVN = new Locale("vi", "VN");
	    NumberFormat vn = NumberFormat.getInstance(localeVN);
	    
	    String tienvnd = vn.format(price);
	    return tienvnd +"đ";
    }

}
