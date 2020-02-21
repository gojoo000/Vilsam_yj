package vo;

import java.util.Date;

public class MemberBean {
	
	private String MEMBER_NUM;
	private String MEMBER_ID;
	private String MEMBER_PW;
	private String MEMBER_NAME;
	private String MEMBER_GENDER;
	private String MEMBER_EMAIL;
	private String MEMBER_ZIPCODE;
	private String MEMBER_ADDR1;
	private String MEMBER_ADDR2;
	private String MEMBER_PHONE1;
	private String MEMBER_PHONE2;
	private String MEMBER_BIRTH;
	private String MEMBER_TYPE;
	private String CRT_DT;
	
	
	public String getCRT_DT() {
		return CRT_DT;
	}
	public void setCRT_DT(String cRT_DT) {
		CRT_DT = cRT_DT;
	}
	public String getMEMBER_NUM() {
		return MEMBER_NUM;
	}
	public void setMEMBER_NUM(String mEMBER_NUM) {
		MEMBER_NUM = mEMBER_NUM;
	}
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public String getMEMBER_PW() {
		return MEMBER_PW;
	}
	public void setMEMBER_PW(String mEMBER_PW) {
		MEMBER_PW = mEMBER_PW;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}
	public String getMEMBER_GENDER() {
		return MEMBER_GENDER;
	}
	public void setMEMBER_GENDER(String mEMBER_GENDER) {
		MEMBER_GENDER = mEMBER_GENDER;
	}
	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}
	public void setMEMBER_EMAIL(String mEMBER_EMAIL) {
		MEMBER_EMAIL = mEMBER_EMAIL;
	}
	public String getMEMBER_ZIPCODE() {
		return MEMBER_ZIPCODE;
	}
	public void setMEMBER_ZIPCODE(String mEMBER_ZIPCODE) {
		MEMBER_ZIPCODE = mEMBER_ZIPCODE;
	}
	public String getMEMBER_ADDR1() {
		return MEMBER_ADDR1;
	}
	public void setMEMBER_ADDR1(String mEMBER_ADDR1) {
		MEMBER_ADDR1 = mEMBER_ADDR1;
	}
	public String getMEMBER_ADDR2() {
		return MEMBER_ADDR2;
	}
	public void setMEMBER_ADDR2(String mEMBER_ADDR2) {
		MEMBER_ADDR2 = mEMBER_ADDR2;
	}
	public String getMEMBER_PHONE1() {
		return MEMBER_PHONE1;
	}
	public void setMEMBER_PHONE1(String mEMBER_PHONE1) {
		MEMBER_PHONE1 = mEMBER_PHONE1;
	}
	public String getMEMBER_PHONE2() {
		return MEMBER_PHONE2;
	}
	public void setMEMBER_PHONE2(String mEMBER_PHONE2) {
		MEMBER_PHONE2 = mEMBER_PHONE2;
	}
	public String getMEMBER_BIRTH() {
		return MEMBER_BIRTH;
	}
	public void setMEMBER_BIRTH(String mEMBER_BIRTH) {
		MEMBER_BIRTH = mEMBER_BIRTH;
	}
	public String getMEMBER_TYPE() {
		return MEMBER_TYPE;
	}
	public void setMEMBER_TYPE(String mEMBER_TYPE) {
		MEMBER_TYPE = mEMBER_TYPE;
	}
	
	
	
	
	
	/*
	 * private String MEMBER_NUM; private String MEMBER_ID; private String
	 * MEMBER_PW; private String MEMBER_NAME; private int MEMBER_AGE; private String
	 * MEMBER_GENDER; private String MEMBER_EMAIL; private String MEMBER_ZIPCODE;
	 * private String MEMBER_ADDRESS1; private String MEMBER_ADDRESS2; private
	 * String MEMBER_PHONECD; private String MEMBER_PHONENUM; private String
	 * MEMBER_BIRTHYY; private String MEMBER_BIRTHMM; private String MEMBER_BIRTHDD;
	 * 
	 * public String getMEMBER_BIRTHYY() { return MEMBER_BIRTHYY; }
	 * 
	 * public String getMEMBER_BIRTHMM() { return MEMBER_BIRTHMM; }
	 * 
	 * public String getMEMBER_BIRTHDD() { return MEMBER_BIRTHDD; }
	 * 
	 * public String getMEMBER_ID() { return MEMBER_ID; }
	 * 
	 * public String getMEMBER_PW() { return MEMBER_PW; }
	 * 
	 * public String getMEMBER_NAME() { return MEMBER_NAME; }
	 * 
	 * public int getMEMBER_AGE() { return MEMBER_AGE; }
	 * 
	 * public String getMEMBER_GENDER() { return MEMBER_GENDER; }
	 * 
	 * public String getMEMBER_EMAIL() { return MEMBER_EMAIL; }
	 * 
	 * public String getMEMBER_ZIPCODE() { return MEMBER_ZIPCODE; }
	 * 
	 * public String getMEMBER_ADDRESS1() { return MEMBER_ADDRESS1; }
	 * 
	 * public String getMEMBER_ADDRESS2() { return MEMBER_ADDRESS2; }
	 * 
	 * public String getMEMBER_PHONECD() { return MEMBER_PHONECD; }
	 * 
	 * public String getMEMBER_PHONENUM() { return MEMBER_PHONENUM; }
	 * 
	 * public void setMEMBER_BIRTHYY(String mEMBER_BIRTHYY) { MEMBER_BIRTHYY =
	 * mEMBER_BIRTHYY; }
	 * 
	 * public void setMEMBER_BIRTHMM(String mEMBER_BIRTHMM) { MEMBER_BIRTHMM =
	 * mEMBER_BIRTHMM; }
	 * 
	 * public void setMEMBER_BIRTHDD(String mEMBER_BIRTHDD) { MEMBER_BIRTHDD =
	 * mEMBER_BIRTHDD; }
	 * 
	 * public void setMEMBER_ID(String mEMBER_ID) { MEMBER_ID = mEMBER_ID; }
	 * 
	 * public void setMEMBER_PW(String mEMBER_PW) { MEMBER_PW = mEMBER_PW; }
	 * 
	 * public void setMEMBER_NAME(String mEMBER_NAME) { MEMBER_NAME = mEMBER_NAME; }
	 * 
	 * public void setMEMBER_AGE(int mEMBER_AGE) { MEMBER_AGE = mEMBER_AGE; }
	 * 
	 * public void setMEMBER_GENDER(String mEMBER_GENDER) { MEMBER_GENDER =
	 * mEMBER_GENDER; }
	 * 
	 * public void setMEMBER_EMAIL(String mEMBER_EMAIL) { MEMBER_EMAIL =
	 * mEMBER_EMAIL; }
	 * 
	 * public void setMEMBER_ZIPCODE(String mEMBER_ZIPCODE) { MEMBER_ZIPCODE =
	 * mEMBER_ZIPCODE; }
	 * 
	 * public void setMEMBER_ADDRESS1(String mEMBER_ADDRESS1) { MEMBER_ADDRESS1 =
	 * mEMBER_ADDRESS1; }
	 * 
	 * public void setMEMBER_ADDRESS2(String mEMBER_ADDRESS2) { MEMBER_ADDRESS2 =
	 * mEMBER_ADDRESS2; }
	 * 
	 * public void setMEMBER_PHONECD(String mEMBER_PHONECD) { MEMBER_PHONECD =
	 * mEMBER_PHONECD; }
	 * 
	 * public void setMEMBER_PHONENUM(String mEMBER_PHONENUM) { MEMBER_PHONENUM =
	 * mEMBER_PHONENUM; }
	 */

}
