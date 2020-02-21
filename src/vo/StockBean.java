package vo;

public class StockBean {
	private int num;
	private String io;
	private int in;
	private int out;
	private String product_num;
	private int count;
	private String dateyy;
	private String datemm;
	private String datedd;
	private String product_name;	
	private int sellnum=0;

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getSellnum() {
		return sellnum;
	}

	public void setSellnum(int sellnum) {
		this.sellnum = sellnum;
	}

	public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getIo() {
		return io;
	}

	public void setIo(String io) {
		this.io = io;
	}

	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDateyy() {
		return dateyy;
	}

	public void setDateyy(String dateyy) {
		this.dateyy = dateyy;
	}

	public String getDatemm() {
		return datemm;
	}

	public void setDatemm(String datemm) {
		this.datemm = datemm;
	}

	public String getDatedd() {
		return datedd;
	}

	public void setDatedd(String datedd) {
		this.datedd = datedd;
	}

}