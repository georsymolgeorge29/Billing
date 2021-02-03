package application;

public class Staff {
	private int staff_id;
	private String staff_name;
	private int mobile_no;
	private String address;
	private String email_d;	
	private String password;
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public int getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(int mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail_d() {
		return email_d;
	}
	public void setEmail_d(String email_d) {
		this.email_d = email_d;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	private String comp_name;
	public Staff(int staff_id, String staff_name, int mobile_no, String address, String email_d, String password,
			String comp_name) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.mobile_no = mobile_no;
		this.address = address;
		this.email_d = email_d;
		this.password = password;
		this.comp_name = comp_name;
	}
}
