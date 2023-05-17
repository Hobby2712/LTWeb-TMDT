package DAO;

import java.util.List;

import Entity.User;

public interface UserDAO {
	public User login(String user, String pass);
	public User checkAccountExist(String user);
	public User checkEmailExist(String email);	
	public User checkAccount(String username_email);
	public void singup(String user, String pass, String email);
	public void sendEmail(String receiver_email, String content);
	public String getRandom();
	
	public void updateProfile(String name, String address, String phone, int id);
	public void changPass(String user, String pass);
	List<User> getAll(int index);
	void addNewUser(User user);
	int countAccount();
	int countSearch(String txtSearch);
	List<User> searchByName(String txtSearch, int index);
	String getUsernameById(String index);
	String getEmailById(String index);
	String getPasswordById(String index);
	List<String> getAllEmail();
	String getUsernameByEmail(String index);
	String getFullNameById(int index);
	String getPhoneById(int index);
	String getAddressById(int index);
}
