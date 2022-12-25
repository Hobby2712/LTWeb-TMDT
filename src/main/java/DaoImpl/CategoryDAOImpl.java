package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectDB;
import DAO.CategoryDAO;
import Entity.Category;

public class CategoryDAOImpl extends ConnectDB implements CategoryDAO {

	@Override
	public List<Category> getAllCategory1() {
		List<Category> clist = new ArrayList<Category>();
		String query = "SELECT * FROM category1";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setImage(rs.getString(3));
				clist.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clist;
	}

	@Override
	public List<Category> getAllCategory2() {
		List<Category> clist = new ArrayList<Category>();
		String query = "SELECT * FROM category2";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setImage(rs.getString(3));
				clist.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clist;
	}
	
	@Override
	public List<Category> getAllCategory2PT(int index) {
		List<Category> clist = new ArrayList<Category>();
		String query = "select * from category2\r\n"
				+ "order by cId OFFSET ? rows FETCH NEXT 10 ROWS Only;";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, index * 10 - 10);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setImage(rs.getString(3));
				clist.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clist;
	}

	@Override
	public void addCategory2(Category cate) {
		String query = "Insert into category2 values (?,?,?,?)";
		try {
			long millis = System.currentTimeMillis();
			java.sql.Date now = new java.sql.Date(millis);

			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cate.getName());
			ps.setString(2, cate.getImage());
			ps.setDate(3, now);
			ps.setInt(4, cate.getcIdBig());
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

	@Override
	public void deleteCate2(int cId) {
		String query = "delete from category2 where cId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cId);
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}
	
	@Override
	public int countCategory() {
		String query = "select count(*) from category2";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	@Override
	public List<Category> getAllCategory2Search(String search, int index) {
		List<Category> clist = new ArrayList<Category>();
		String query = "select * from category2 where cName like ?\r\n"
				+ "order by cId OFFSET ? rows FETCH NEXT 10 ROWS Only;";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + search + "%");
			ps.setInt(2, index * 10 - 10);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setImage(rs.getString(3));
				clist.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clist;
	}
	
	@Override
	public int countSearch(String search) {
		String query = "select count(*) from category2 where cName like ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "%" + search + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

}
