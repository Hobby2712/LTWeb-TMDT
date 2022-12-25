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
	
	public static void main(String[] args) {
		StoreDAO dao = new StoreDAOImpl();
		System.out.print(dao.GetStoreIdFromUID(6));
	}
}
