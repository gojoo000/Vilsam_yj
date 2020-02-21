package vo;

public class ProductBean {
	private String product_num;
	private String product_image;
	private String product_name;
	private int product_price;
	private String product_category;
	private int product_jaego;
	
	public int getProduct_jaego() {
		return product_jaego;
	}
	public void setProduct_jaego(int product_jaego) {
		this.product_jaego = product_jaego;
	}
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(String product_num, String product_image, String product_name, int product_price,
			String product_category) {
		super();
		this.product_num = product_num;
		this.product_image = product_image;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_category = product_category;
	}
	public String getProduct_num() {
		return product_num;
	}
	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}


}