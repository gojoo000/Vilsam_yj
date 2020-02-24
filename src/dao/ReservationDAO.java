package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.MemberBean;
import vo.ReservationBean;

public class ReservationDAO {
	DataSource ds;
	Connection con;

	private static ReservationDAO insPDAO = new ReservationDAO();

	private ReservationDAO() {
	}//

	public static ReservationDAO getInstance() {
		return insPDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	//예약 수
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println("getConnection");
			pstmt = con.prepareStatement("SELECT count(*) FROM TB_RESERVATION"); // �쟾泥� 湲� 媛��닔 援ы븯湲�
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1); // �쟾泥� 湲� 媛��닔瑜� listCount�뿉 �븷�떦(���옣)
			}
		} catch (Exception e) {
			System.out.println("getListCount �뿉�윭 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	// 예약등록
	public int insertReservation(ReservationBean reser) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement("select max(RESER_NUM) from TB_RESERVATION");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into TB_RESERVATION (RESER_NUM,ROOM_NUM,MEMBER_ID,RESER_DATE)";
			sql += "values(?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, reser.getRoom_num());
			pstmt.setString(3, reser.getMember_id());
			pstmt.setString(4,reser.getReser_date());
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("ReservationInsert �뿉�윭 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}
	//예약 중복체크
	public int checkReservation(String room_num,String reser_date) {
		String sql = "SELECT * FROM TB_RESERVATION WHERE ROOM_NUM=? AND RESER_DATE=?";
		PreparedStatement pstmt = null;
		int flag = 0;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, room_num);
			pstmt.setString(2, reser_date);
			rs = pstmt.executeQuery();

			
			if (rs.next()) {
				flag = 1;
			}else {
				flag = 0;
			}
			
			System.out.println("중복검사 flag  : "+flag);
			
			
		} catch (Exception ex) {
			System.out.println("id중복체크 에러" + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return flag;
	}

	// 예약 리스트조회
	public ArrayList<ReservationBean> selectReserList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT R.RESER_NUM, R.RESER_DATE, R.MEMBER_ID, R.ROOM_NUM";
		sql += " FROM TB_RESERVATION R, TB_ROOM O, TB_MEMBER M ";
		sql += "WHERE R.ROOM_NUM = O.ROOM_NUM AND R.MEMBER_ID = M.MEMBER_ID; ";
		ArrayList<ReservationBean> reserList = new ArrayList<ReservationBean>();
		ReservationBean room = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				room = new ReservationBean();
				room.setRoom_num(rs.getInt("ROOM_NUM"));
				room.setReser_num(rs.getInt("RESER_NUM"));
				room.setMember_id(rs.getString("MEMBER_ID"));
				room.setReser_date(rs.getString("RESER_DATE"));
				reserList.add(room);
			}

		} catch (Exception ex) {
			System.out.println("getList 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return reserList;

	}

	//예약정보 조회
	public ReservationBean selectReservation(String reser_num) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationBean roomBean = null;
		String sql = "select * from TB_RESERVATION WHERE RESER_NUM=?";
		
		System.out.println(sql+reser_num);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reser_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				roomBean = new ReservationBean();
				roomBean.setReser_num(rs.getInt("RESER_NUM"));
				roomBean.setRoom_num(rs.getInt("ROOM_NUM"));
				roomBean.setMember_id(rs.getString("MEMBER_ID"));
				roomBean.setReser_date(rs.getString("RESER_DATE"));

			}
			System.out.println(reser_num);
		} catch (Exception ex) {
			System.out.println("getDetail 에러 : " + ex);
		} finally {
			rs.close();
			pstmt.close();
		}

		return roomBean;

	}

	//예약삭제
	public int delProd(String RESER_NUM) {
		//System.out.println(con);

		PreparedStatement pstmt = null;
		String sql = "delete from TB_RESERVATION where RESER_NUM=?";
		int deleteCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, RESER_NUM);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("상품Delete에러 : " + ex);
		} finally {
			close(pstmt);
		}
		return deleteCount;

	}
	
	
	public List<ReservationBean> checkReservation(String type) {//,int room_num 하나 더만들기
		System.out.println("^^^ "+type.length());
	      
	      String sql = "SELECT B.ROOM_NAME,A.RESER_DATE FROM TB_RESERVATION A, TB_ROOM B WHERE A.ROOM_NUM=B.ROOM_NUM";
	      
	      
	      if(type.length()>0) {
	         sql += " AND A.MEMBER_ID=? ";
	      }
		/*
		 * if(room_num.length()>0) { sql += " AND A.MEMBER_ID=? "; } //A.ROOM_NUM
		 */	      
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      ArrayList<ReservationBean> reserveList = new ArrayList<ReservationBean>();
	      ReservationBean rsv = null;
	      
	      try {
	         pstmt = con.prepareStatement(sql);
	         //pstmt.setString(1, memberId);
	         if(type.length()>0) {
	            pstmt.setString(1, type);               
	         }
			/*
			 * if(room_num.length()>0) { pstmt.setString(1, room_num); }
			 */
	         rs = pstmt.executeQuery();

	         System.out.println("#### checkReservation DAO  "+ sql);
	         
	         if (rs.next()) {
	            do {
	               rsv = new ReservationBean();
	               rsv.setReser_date(rs.getString("RESER_DATE"));
	               rsv.setRoom_name(rs.getString("ROOM_NAME"));               
	               System.out.println("################## RESER_DATE "+rs.getString("RESER_DATE"));
	               reserveList.add(rsv);
	            } while (rs.next());
	         }
	         
	         
	      } catch (Exception ex) {
	         System.out.println("calendar 에러" + ex);
	      } finally {
	         close(rs);
	         close(pstmt);
	      }

	      return reserveList;
	}
	
	public List<ReservationBean> checkReservation(int room_num) {
		String str = Integer.toString(room_num);
		System.out.println("^^^ "+str.length());
	      
	      String sql = "SELECT B.ROOM_NAME,A.RESER_DATE FROM TB_RESERVATION A, TB_ROOM B WHERE A.ROOM_NUM=B.ROOM_NUM";
	      

		
		  if(str.length()>0) { sql += " AND A.ROOM_NUM=? "; } //A.ROOM_NUM
		 	      
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      ArrayList<ReservationBean> reserveList = new ArrayList<ReservationBean>();
	      ReservationBean rsv = null;
	      
	      try {
	         pstmt = con.prepareStatement(sql);
	         //pstmt.setString(1, memberId);
			  if(str.length()>0) { pstmt.setInt(1, room_num); }
			 
	         rs = pstmt.executeQuery();

	         System.out.println("#### checkReservation DAO  "+ sql);
	         
	         if (rs.next()) {
	            do {
	               rsv = new ReservationBean();
	               rsv.setReser_date(rs.getString("RESER_DATE"));
	               rsv.setRoom_name(rs.getString("ROOM_NAME"));               
	               System.out.println("################## RESER_DATE "+rs.getString("RESER_DATE"));
	               reserveList.add(rsv);
	            } while (rs.next());
	         }
	         
	         
	      } catch (Exception ex) {
	         System.out.println("calendar 에러" + ex);
	      } finally {
	         close(rs);
	         close(pstmt);
	      }

	      return reserveList;
	}
}
