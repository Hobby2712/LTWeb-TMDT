package Entity;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ThongKe {
	private String uName;
	private String uAddress;
	private int pId;
	private int quantity;
	private Date creatDate;
	private int total;
	
	
	public ThongKe() {
		super();
	}


	public ThongKe(String uName, String uAddress, int pId, int quantity, Date creatDate, int total) {
		super();
		this.uName = uName;
		this.uAddress = uAddress;
		this.pId = pId;
		this.quantity = quantity;
		this.creatDate = creatDate;
		this.total = total;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getuAddress() {
		return uAddress;
	}


	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}


	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Date getCreatDate() {
		return creatDate;
	}


	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "ThongKe [uName=" + uName + ", uAddress=" + uAddress + ", pId=" + pId + ", quantity=" + quantity
				+ ", creatDate=" + creatDate + ", total=" + total + "]";
	}
	
	public String DateFormat(Date t)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); // HH:mm:ss
		String date = simpleDateFormat.format(t);
		return date;
	}
	
}
