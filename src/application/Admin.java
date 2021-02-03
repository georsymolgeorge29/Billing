package application;

public class Admin {
	private int account_id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;	
	private String password;
	private String address;
	private int contact_no;
	private String comp_name;
	public Admin(int account_id, String username, String firstname, String lastname, String email, String password,
			String address, int contact_no, String comp_name) {
		super();
		this.account_id = account_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact_no = contact_no;
		this.comp_name = comp_name;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact_no() {
		return contact_no;
	}
	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	
	
}
