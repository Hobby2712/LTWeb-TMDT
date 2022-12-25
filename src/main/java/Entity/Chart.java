package Entity;

import java.text.NumberFormat;
import java.util.Locale;

public class Chart {
	int month;
	String store;
	int total;
	
	
	
	public Chart() {
		super();
	}



	public Chart(int month, int total) {
		super();
		this.month = month;
		this.total = total;
	}



	public Chart(int month, String store, int total) {
		super();
		this.month = month;
		this.store = store;
		this.total = total;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}


	public String getStore() {
		return store;
	}



	public void setStore(String store) {
		this.store = store;
	}



	@Override
	public String toString() {
		return "Chart [month=" + month + ", store=" + store + ", total=" + total + "]";
	}
	
	public String tienTe(int price) {
    	Locale localeVN = new Locale("vi", "VN");
	    NumberFormat vn = NumberFormat.getInstance(localeVN);
	    
	    String tienvnd = vn.format(price);
	    return tienvnd +"đ";
    }
	
}
