package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import vo.SellListBean;

public class SellDAO {
	public static SellDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private static SellDAO sellDAO = new SellDAO();

	private SellDAO() {
	}

	public static SellDAO getInstance() {
		if (instance == null) {
			instance = new SellDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 二쇰Ц�쓽 媛쒖닔 援ы븯湲�
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println("getConnection");
			pstmt = con.prepareStatement("SELECT count(*) FROM SELLLIST"); // �쟾泥� 湲� 媛��닔 援ы븯湲�
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

	// 二쇰Ц �벑濡�.
	public int insertArticle(SellListBean article) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement("select max(SELLNUM) from TB_SELLLIST");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into TB_SELLLIST (SELLNUM,PRODUCT_NUM,MEMBER_ID,SELL_COUNT,SELL_YN,SELL_DATE)";
			sql += "values(?,?,?,?,'s',now())";
//char(1)�삎�쑝濡�
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getProduct_num());
			pstmt.setString(3, article.getMember_id());
			pstmt.setInt(4, article.getSell_count());
			/*
			 * pstmt.setString(5, article.getSell_yn()); pstmt.setDate(6,
			 * article.getSell_date());
			 */
			insertCount = pstmt.executeUpdate();
			if(insertCount>0) {
				insertCount=num;
			}

		} catch (Exception ex) {
			System.out.println("ProductInsert �뿉�윭 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//
	public ArrayList<SellListBean> selectArticleList(String MEMBER_ID,String MEMBER_TYPE) {
//if id媛� admin �씠硫� where 援щЦ �뾾怨� �쉶�썝�씠硫� where �엳怨� id=?臾쇱쓬�몴 �뾾�씠
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT S.SELLNUM, S.PRODUCT_NUM, S.MEMBER_ID,S.SELL_COUNT,S.SELL_YN,S.SELL_DATE";
				sql += " FROM TB_PRODUCT P, TB_SELLLIST S ";
				sql += "WHERE P.PRODUCT_NUM = S.PRODUCT_NUM ";
		if (MEMBER_TYPE.equals("admin")) {
			sql += "";
		}else {
			sql += " WHERE S.MEMBER_ID='"+MEMBER_ID+"'";	
		}
		//sql += " GROUP BY SELLLIST.PRODUCT_NUM";
		


System.out.println(sql);

		ArrayList<SellListBean> articleList = new ArrayList<SellListBean>();
		SellListBean sell = null;
		/*
		 * int startrow=(page-1)*10; //�씫湲� �떆�옉�븷 row 踰덊샇..
		 */
		try {
			pstmt = con.prepareStatement(sql);
			/* pstmt.setInt(1, startrow); */
			rs = pstmt.executeQuery();

			while (rs.next()) {
				sell = new SellListBean();
				sell.setSellnum(rs.getInt("sellnum"));
				sell.setProduct_num(rs.getString("PRODUCT_NUM"));
				sell.setMember_id(rs.getString("MEMBER_ID"));
				sell.setSell_count(rs.getInt("sell_count"));
				sell.setSell_yn(rs.getString("sell_yn"));
				sell.setSell_date(rs.getDate("sell_date"));

				articleList.add(sell);
			}

		} catch (Exception ex) {
			System.out.println("getList �뿉�윭 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	// 湲� �궡�슜 蹂닿린.
	public SellListBean selectProduct(String product_num) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SellListBean sell = null;
		String sql = "select product.PRODUCT_NUM,PRODUCT_IMAGE, PRODUCT_CATEGORY,PRODUCT_NAME,PRODUCT_PRICE, SUM(INQTY) AS 'INQTY', ";
		sql += " SUM(OUTQTY) AS 'OUTQTY' FROM product JOIN pdstock";
		sql += " ON product.PRODUCT_NUM = pdstock.PRODUCT_NUM WHERE product.PRODUCT_NUM =? GROUP BY pdstock.PRODUCT_NUM";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				sell = new SellListBean();
				sell.setProduct_num(rs.getString("PRODUCT_NUM"));
				sell.setMember_id(rs.getString("MEMBER_ID"));
				sell.setSell_count(rs.getInt("sell_count"));
				sell.setSell_yn(rs.getString("sell_yn"));
				sell.setSell_date(rs.getDate("sell_date"));
				sell.setTot_price((rs.getInt("product.PRODUCT_PRICE") * rs.getInt("SELL_COUNT")));

			}
			System.out.println(product_num);
		} catch (Exception ex) {
			System.out.println("getDetail �뿉�윭 : " + ex);
		} finally {
			rs.close();
			pstmt.close();
		}

		return sell;

	}

	/*
	 * // �긽�뭹�닔�젙 public int updateProd(MultipartRequest multi) throws SQLException {
	 * Connection conn = null; PreparedStatement ps = null;
	 * 
	 * String PRODUCT_IMAGE = multi.getParameter("PRODUCT_IMAGE"); String
	 * PRODUCT_CATEGORY = multi.getParameter("PRODUCT_CATEGORY"); String
	 * PRODUCT_NAME = multi.getParameter("PRODUCT_NAME"); // String PRODUCT_IMAGENew
	 * = multi.getFilesystemName("PRODUCT_IMAGENew"); //
	 * 
	 * if (PRODUCT_IMAGENew == null) { PRODUCT_IMAGENew =
	 * multi.getParameter("PRODUCT_IMAGEOld"); }
	 * 
	 * String PRODUCT_PRICE = multi.getParameter("PRODUCT_PRICE"); String
	 * PRODUCT_NUM = multi.getParameter("PRODUCT_NUM");
	 * 
	 * String sql = "update product set PRODUCT_IMAGE=?," +
	 * "PRODUCT_NAME=?,PRODUCT_PRICE=?" + "PRODUCT_CATEGORY=? where PRODUCT_NUM=?";
	 * 
	 * try { conn = getConnection(); ps = conn.prepareStatement(sql);
	 * 
	 * ps.setString(1, PRODUCT_IMAGE); ps.setString(2, PRODUCT_NAME); ps.setInt(3,
	 * Integer.parseInt(PRODUCT_PRICE)); ps.setString(4, PRODUCT_CATEGORY);
	 * ps.setInt(5, Integer.parseInt(PRODUCT_NUM));
	 * 
	 * return ps.executeUpdate(); } finally { if (ps != null) ps.close(); if (conn
	 * != null) conn.close(); } }// updateProd()
	 * 
	 * // �긽�뭹�궘�젣 public int delProd(String PRODUCT_NUM) throws SQLException {
	 * Connection conn = null; PreparedStatement ps = null; String sql =
	 * "delete from product where PRODUCT_NUM=?";
	 * 
	 * try { conn = getConnection(); ps = conn.prepareStatement(sql);
	 * ps.setString(1, PRODUCT_NUM); int n = ps.executeUpdate(); return n; } finally
	 * { if (ps != null) ps.close(); if (conn != null) conn.close(); } }//
	 * delProd()////////
	 */
}
