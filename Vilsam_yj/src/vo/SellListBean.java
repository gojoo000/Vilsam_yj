package vo;

import java.sql.Date;
import java.sql.Timestamp;

public class SellListBean {
	private int sellnum;
	private String product_num;
	private String member_id;
	private int sell_count;
	private String sell_yn;
	private Date sell_date;
	private int tot_price;

	public int getTot_price() {
		return tot_price;
	}

	public void setTot_price(int tot_price) {
		this.tot_price = tot_price;
	}

	public int getSellnum() {
		return sellnum;
	}

	public void setSellnum(int sellnum) {
		this.sellnum = sellnum;
	}

	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getSell_count() {
		return sell_count;
	}

	public void setSell_count(int sell_count) {
		this.sell_count = sell_count;
	}

	public String getSell_yn() {
		return sell_yn;
	}

	public void setSell_yn(String sell_yn) {
		this.sell_yn = sell_yn;
	}

	public Date getSell_date() {
		return sell_date;
	}

	public void setSell_date(Date sell_date) {
		this.sell_date = sell_date;
	}

}
