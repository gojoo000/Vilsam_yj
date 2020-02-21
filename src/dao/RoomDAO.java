package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

import vo.RoomBean;

public class RoomDAO {
	DataSource ds;
	Connection con;

	private static RoomDAO insPDAO = new RoomDAO();

	private RoomDAO() {
	}//

	public static RoomDAO getInstance() {
		return insPDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 방 개수 세기
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println("getConnection");
			pstmt = con.prepareStatement("SELECT count(*) FROM TB_ROOM");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	// 怨듦컙 �벑濡�.
	public int insertArticle(RoomBean article) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement("select max(ROOM_NUM) from TB_ROOM");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into TB_ROOM (ROOM_NUM,ROOM_NAME,ROOM_IMAGE,ROOM_SIZE,ROOM_PRICE)";
			sql += "values(?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getRoom_name());
			pstmt.setString(3, article.getRoom_image());
			pstmt.setInt(4, article.getRoom_size());
			pstmt.setInt(5, article.getRoom_price());
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("RoomInsert Error : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	// 방 리스트
	public ArrayList<RoomBean> selectArticleList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_ROOM ";
		ArrayList<RoomBean> articleList = new ArrayList<RoomBean>();
		RoomBean room = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				room = new RoomBean();
				room.setRoom_num(rs.getInt("ROOM_NUM"));
				room.setRoom_name(rs.getString("ROOM_NAME"));
				room.setRoom_size(rs.getInt("ROOM_SIZE"));
				room.setRoom_image(rs.getString("ROOM_IMAGE"));
				room.setRoom_price(rs.getInt("ROOM_PRICE"));
				articleList.add(room);
			}

		} catch (Exception ex) {
			System.out.println("getList Error : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	// 방 정보 조회
	public RoomBean selectRoom(int room_num) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RoomBean roomBean = null;
		String sql = "select room.ROOM_NUM,ROOM_IMAGE, ROOM_CATEGORY,ROOM_NAME,ROOM_PRICE, SUM(INQTY) AS 'INQTY', ";
		sql += " SUM(OUTQTY) AS 'OUTQTY' FROM room JOIN pdstock";
		sql += " ON room.ROOM_NUM = pdstock.ROOM_NUM WHERE room.ROOM_NUM =? GROUP BY pdstock.ROOM_NUM";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, room_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				roomBean = new RoomBean();
				roomBean.setRoom_num(rs.getInt("ROOM_NUM"));
				roomBean.setRoom_image(rs.getString("ROOM_IMAGE"));
				roomBean.setRoom_name(rs.getString("ROOM_NAME"));
				roomBean.setRoom_price(rs.getInt("ROOM_PRICE"));

			}
			System.out.println(room_num);
		} catch (Exception ex) {
			System.out.println("getDetail Error : " + ex);
		} finally {
			rs.close();
			pstmt.close();
		}

		return roomBean;

	}


	// 방 정보 수정
	public int updateRoom(RoomBean article) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update TB_ROOM set ROOM_NAME=?,ROOM_IMAGE=?,ROOM_PRICE=?,ROOM_SIZE=? where ROOM_NUM=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getRoom_name());
			pstmt.setInt(2, article.getRoom_price());
			pstmt.setInt(3, article.getRoom_size());
			pstmt.setString(4, article.getRoom_image());
			pstmt.setInt(5, article.getRoom_num());
			updateCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Room Info Modify Error : " + ex);
		} finally {
			close(pstmt);
		}

		return updateCount;
	}

	// 방 삭제
	public int delProd(String ROOM_NUM) {
		//System.out.println(con);

		PreparedStatement pstmt = null;
		String sql = "delete from TB_ROOM where ROOM_NUM=?";
		int deleteCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ROOM_NUM);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("RoomDelete Error : " + ex);
		} finally {
			close(pstmt);
		}
		return deleteCount;

	}
}
