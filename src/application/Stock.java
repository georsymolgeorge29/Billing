package application;

public class Stock {
	private String product_id;
	private String product_name;
	private String comp_name;
	private String category_name;
	private String exp_date;	
	private int quantity;
	private int quantity_add;
	private int mrp;
	private int discount;
	public Stock(String product_id, String product_name, String comp_name, String category_name, String exp_date,
			int quantity, int quantity_add, int mrp, int discount) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.comp_name = comp_name;
		this.category_name = category_name;
		this.exp_date = exp_date;
		this.quantity = quantity;
		this.quantity_add = quantity_add;
		this.mrp = mrp;
		this.discount = discount;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity_add() {
		return quantity_add;
	}
	public void setQuantity_add(int quantity_add) {
		this.quantity_add = quantity_add;
	}
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
