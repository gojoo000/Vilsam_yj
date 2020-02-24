package vo;

import java.sql.Date;

public class ReservationBean {
	private int reser_num;
	private int room_num;
	private String member_id;
	private String reser_date;
	private String room_name;
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public int getReser_num() {
		return reser_num;
	}
	public void setReser_num(int reser_num) {
		this.reser_num = reser_num;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getReser_date() {
		return reser_date;
	}
	public void setReser_date(String reser_date) {
		this.reser_date = reser_date;
	}
	
	

}