package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import DAO.CartDAO;
import DAO.ProductDAO;
import Entity.Cart;

public class CartDAOImpl extends ConnectDB implements CartDAO {
	ProductDAO p = new ProductDAOImpl();
	
	public List<Cart> getAllItemsCart(int cartId, int index) {
		List<Cart> cartlist = new ArrayList<>();
		String query = "use NKDShop\r\n"
				+ "select cartId, productId, cartItems.[count], totalPrice\r\n"
				+ "from cartItems\r\n"
				+ "where cartId=?\r\n"
				+ "order by id OFFSET ? rows FETCH NEXT 10 ROWS Only";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			ps.setInt(2, index * 10 - 10);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt(1));
				cart.setP(p.getProductByID(rs.getString(2)));
				cart.setCount(rs.getInt(3));
				cart.setTotalprice(rs.getInt(4));
				cartlist.add(cart);
			}
		} catch (Exception e) {
		}
		return cartlist;
	}

	@Override
	public int countCart(int cartId) {
		String query = "select count (*) from cartItems where cartId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	@Override
	public Cart getItemByPID(int cartId, int pid) {
		String query = "select cartId, productId, [count], totalPrice\r\n"
				+ "from cartItems \r\n"
				+ "where productId=? and cartId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, pid);
			ps.setInt(2, cartId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Cart(rs.getInt(1), p.getProductByID(rs.getString(2)), rs.getInt(3), rs.getInt(4));
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insertCartItemIcon(int cartId, int pId) {
		String query = "Insert into cartItems values(?,?,1,null)";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			ps.setInt(2, pId);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }		
	}
	@Override
	public void insertCartItem(int cartId, int pId, int quantity) {
		String query = "Insert into cartItems values(?,?,?,null)";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			ps.setInt(2, pId);
			ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }		
	}

	@Override
	public void insertCartItemDetail(int cartId, int pId, int quantity) {
		String query = "Insert into cartItems values(?,?,?,null)";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			ps.setInt(2, pId);
			ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }		
	}

	@Override
	public void updateCountItemIcon(int cartId, int pId) {
		String query = "update cartItems\r\n"
				+ "set [count]=[count]+1\r\n"
				+ "where productId=? and cartId=?";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, pId);
			ps.setInt(2, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }	
	}
// Chuaw lamf
	@Override
	public void updateCountItemCart(int cartId, int pId, int quantity) {
		String query = "update cartItems\r\n"
				+ "set [count]=?\r\n"
				+ "where productId=? and cartId=?";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setInt(2, pId);
			ps.setInt(3, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }	
	}

	@Override
	public int getCartIdByUId(int uid) {
		String query = "select cartId from cart \r\n"
				+ "where uid=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public void deleteItemCart(int cartId, int pId) {
		String query = "delete from cartItems\n"
                + "where productId=? and cartId=?";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, pId);
			ps.setInt(2, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void updateCountItemDetail(int cartId, int pId, int quantity) {
		String query = "update cartItems\r\n"
				+ "set [count]=[count]+?\r\n"
				+ "where productId=? and cartId=?";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setInt(2, pId);
			ps.setInt(3, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }	
	}

	@Override
	public int getTotalCart(int cartId) {
		String query = "select SUM(totalPrice) from cartItems\r\n"
				+ "where cartId=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	@Override
	public void deleteAllItemCart(int cartId) {
		String query = "delete from cartItems\n"
                + "where cartId=?";
        try {
        	Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
