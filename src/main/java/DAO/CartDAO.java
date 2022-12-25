package DAO;

import java.util.List;

import Entity.Cart;

public interface CartDAO {
	public List<Cart> getAllItemsCart(int cartId, int index);
	public Cart getItemByPID(int cartId, int pid);
	public int getCartIdByUId(int uid);
	public int getTotalCart(int cartId);
	
	public int countCart(int cartId);
	public void insertCartItemIcon(int cartId, int pId);
	public void insertCartItemDetail(int cartId, int pId, int quantity);
	
	public void updateCountItemDetail(int cartId, int pId, int quantity);
	public void updateCountItemIcon(int cartId, int pId);
	void updateCountItemCart(int cartId, int pId, int quantity);
	
	public void deleteItemCart(int cartId, int pId);
	void deleteAllItemCart(int cartId);
}
