package vo;

import java.sql.Date;

public class RoomBean {
	private int room_num;
	private String room_name;
	private int room_size;
	private int room_price;
	private String room_image;
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getRoom_image() {
		return room_image;
	}
	public void setRoom_image(String room_image) {
		this.room_image = room_image;
	}
	private String member_id;
	private Date reser_date;
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public int getRoom_size() {
		return room_size;
	}
	public void setRoom_size(int room_size) {
		this.room_size = room_size;
	}
	public int getProduct_price() {
		return room_price;
	}
	public void setProduct_price(int room_price) {
		this.room_price = room_price;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getReser_date() {
		return reser_date;
	}
	public void setReser_date(Date reser_date) {
		this.reser_date = reser_date;
	}
	
	

}