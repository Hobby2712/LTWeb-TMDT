package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectDB;
import DAO.StoreDAO;

public class StoreDAOImpl extends ConnectDB implements StoreDAO{
	
	@Override
	public int GetStoreIdFromUID(int uId) {
		String query = "Select sId from store where ownerId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, uId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Store getStoreById(int sId) {
		String query = "Select * from store where [sId]= ?";
		Connection conn = null;
		PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, sId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Store(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getDate(4),
						rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	public static void main(String[] args) {
		StoreDAO dao = new StoreDAOImpl();
		System.out.print(dao.GetStoreIdFromUID(6));
	}
}
