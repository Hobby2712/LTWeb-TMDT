package Entity;

public class User {
	private int id;
	private String userName;
	private String fullName;
	private String email;
	private String address;
	private String pass;
	private String phone;
	private int role;
	private String image;
	
	public User() {
		super();
	}
	
	public User(int id, String userName, String fullName, String email, String address, String pass, String phone,
			int role, String image) {
		super();
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.pass = pass;
		this.phone = phone;
		this.role = role;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", fullName=" + fullName + ", email=" + email
				+ ", address=" + address + ", pass=" + pass + ", phone=" + phone + ", role=" + role + ", image=" + image
				+ "]";
	}
	
	
}
