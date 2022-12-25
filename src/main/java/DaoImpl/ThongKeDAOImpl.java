package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import DAO.ThongKeDAO;
import Entity.Chart;
import Entity.ThongKe;

public class ThongKeDAOImpl extends ConnectDB implements ThongKeDAO{
	@Override
	public List<Chart> getAllThongKe(int year, int index) {
		List<Chart> tlist = new ArrayList<>();
		String query = "select Month([order].createAt), store.sName , sum(orderdetail.totalPrice)\r\n"
				+ "from [order] join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId\r\n"
				+ "join store\r\n"
				+ "on product.storeId = store.sId\r\n"
				+ "where orderdetail.status=4 and YEAR([order].createAt)=?\r\n"
				+ "Group by Month([order].createAt), store.sName\r\n"
				+ "order by Month([order].createAt) OFFSET ? rows FETCH NEXT 10 ROWS Only;";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ps.setInt(2, index*10-10);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chart t = new Chart();
				t.setMonth(rs.getInt(1));
				t.setStore(rs.getString(2));;
				t.setTotal(rs.getInt(3));
				tlist.add(t);
			}
		} catch (Exception e) {
		}
		return tlist;
	}
	
	@Override
	public List<Chart> getChart(int year){
		List<Chart> tlist = new ArrayList<>();
		String query = "select store.sName, sum(orderdetail.totalPrice)\r\n"
				+ "from [order] join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId\r\n"
				+ "join store\r\n"
				+ "on product.storeId = store.sId\r\n"
				+ "where orderdetail.status=4 and YEAR([order].createAt)=?\r\n"
				+ "Group by store.sName";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chart t = new Chart();
				t.setStore(rs.getString(1));;
				t.setTotal(rs.getInt(2));
				tlist.add(t);
			}
		} catch (Exception e) {
		}
		return tlist;
	}
	
	@Override
	public int countThongKe(int year) {
		int i = 0;
		String query = "select  distinct month([order].createAt), store.sName\r\n"
				+ "from [order] join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId\r\n"
				+ "join store\r\n"
				+ "on product.storeId = store.sId\r\n"
				+ "where orderdetail.status=4 and YEAR([order].createAt)=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
			return i;
		} catch (Exception e) {
		}
		return i;
	}
	
	@Override
	public List<String> getYear() {
		List<String> list = new ArrayList<>();
		String query = "select (Year([order].createAt))\r\n"
				+ "from [order] join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "where orderdetail.status=4\r\n"
				+ "group by Year([order].createAt)\r\n"
				+ "order by Year([order].createAt) desc";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	@Override
	public String getLastedYear() {
		String query = "select max(Year([order].createAt))\r\n"
				+ "from [order]  join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "where orderdetail.status=4";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	
	@Override
	public List<ThongKe> getAllThongKeByStore(int year, int storeId, int index) {
		List<ThongKe> tlist = new ArrayList<>();
		String query = "Select [user].uName, [order].uAddress, orderdetail.productId,orderdetail.count,[order].createAt, orderdetail.totalPrice\r\n"
				+ "from [user] join [order] \r\n"
				+ "on [user].[uId] = [order].[uId]\r\n"
				+ "join orderdetail\r\n"
				+ "on orderdetail.orderId = [order].orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId\r\n"
				+ "where orderdetail.status = 4 and Year([order].createAt)= ? and product.storeId = ?\r\n"
				+ "order by [order].createAt desc OFFSET ? rows FETCH NEXT 10 ROWS Only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ps.setInt(2, storeId);
			ps.setInt(3, index*10-10);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThongKe t = new ThongKe();
				t.setuName(rs.getString(1));
				t.setuAddress(rs.getString(2));
				t.setpId(rs.getInt(3));
				t.setQuantity(rs.getInt(4));
				t.setCreatDate(rs.getDate(5));
				t.setTotal(rs.getInt(6));
				tlist.add(t);
			}
		} catch (Exception e) {
		}
		return tlist;
	}
	
	@Override
	public List<Chart> getChartByStore(int year, int storeId){
		List<Chart> tlist = new ArrayList<>();
		String query = "select MONTH([order].createAt), sum(orderdetail.totalPrice)\r\n"
				+ "from [order] join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId\r\n"
				+ "where orderdetail.status=4 and YEAR([order].createAt)=? and product.storeId=?\r\n"
				+ "Group by MONTH([order].createAt)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ps.setInt(2, storeId);
			ResultSet rs = ps.executeQuery();
			if(getMonthMinByStore(year, storeId) != 1) {
				for(int i=1; i<getMonthMinByStore(year, storeId);i++)
				{
					Chart t = new Chart();
					t.setMonth(i);;
					t.setTotal(0);
					tlist.add(t);
				}
			}	
			while (rs.next()) {
				Chart t = new Chart();
				t.setMonth(rs.getInt(1));;
				t.setTotal(rs.getInt(2));
				tlist.add(t);
			}
		} catch (Exception e) {
		}
		return tlist;
	}
	
	@Override
	public int getMonthMinByStore(int year, int storeId) {
		String query = "select min(MONTH([order].createAt))\r\n"
				+ "from [order] join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId\r\n"
				+ "where orderdetail.status=4 and YEAR([order].createAt)=? and product.storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ps.setInt(2, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	@Override
	public int countThongKeByStore(int year, int storeId) {
		String query = "select count (*)\r\n"
				+ "from [user] join [order]\r\n"
				+ "on [user].[uId] = [order].[uId]\r\n"
				+ "join orderdetail\r\n"
				+ "on orderdetail.orderId = [order].orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId\r\n"
				+ "where orderdetail.status = 4 and Year([order].createAt)= ? and product.storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, year);
			ps.setInt(2, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	@Override
	public List<String> getYearByStore(int storeId) {
		List<String> list = new ArrayList<>();
		String query = "select (Year([order].createAt))\r\n"
				+ "from [order] join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId \r\n"
				+ "where orderdetail.status=4 and product.storeId = ?\r\n"
				+ "group by Year([order].createAt)\r\n"
				+ "order by Year([order].createAt) desc";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	@Override
	public String getLastedYearByStore(int storeId) {
		String query = "select max(Year([order].createAt))\r\n"
				+ "from [order]  join orderdetail\r\n"
				+ "on [order].orderId = orderdetail.orderId\r\n"
				+ "join product \r\n"
				+ "on orderdetail.productId = product.pId\r\n"
				+ "where orderdetail.status=4 and product.storeId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	public static void main(String[] args) {
		ThongKeDAO d = new ThongKeDAOImpl();
		System.out.print(d.countThongKe(2021));
	}
}
