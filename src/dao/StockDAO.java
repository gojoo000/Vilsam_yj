package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.StockBean;

public class StockDAO {
	public static StockDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private static StockDAO stockDAO = new StockDAO();

	private StockDAO() {
	}

	public static StockDAO getInstance() {
		if (instance == null) {
			instance = new StockDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 재고 등록.
	public int insertArticle(StockBean articleList) {
		String sql = "insert into TB_PDSTOCK (PRODUCT_NUM,INQTY,OUTQTY,DATEYY,DATEMM,DATEDD,sellnum,NUM) ";
		/* sql += "values(?,?,?,?,?,?)"; */
		int insertCount = 0;
		int num = 0;
		try {
			pstmt = con.prepareStatement("select max(NUM) from TB_PDSTOCK");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			
			if (articleList.getIo().equals("입고"))
				sql += "values (?,?,0,?,?,?,?,?)";
			else
				sql += "values (?,0,?,?,?,?,?,?)";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, articleList.getProduct_num());
			pstmt.setInt(2, articleList.getCount());
			pstmt.setString(3, articleList.getDateyy());
			pstmt.setString(4, articleList.getDatemm());
			pstmt.setString(5, articleList.getDatedd());
			pstmt.setInt(6, articleList.getSellnum());
			pstmt.setInt(7, num);
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("StockInsert 에러 : " + ex);
		} finally {
			close(pstmt);
		}

		return insertCount;

	}

	/*
	 * public ArrayList list() throws SQLException { Connection con = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; // SELECT StringBuffer
	 * sql = null; int cnt = 0; ArrayList list = null;
	 * 
	 * try { sql = new StringBuffer();
	 * sql.append(" SELECT NUM, DATE, COUNT, PRODUCT_NUM");
	 * sql.append(" FROM pdstock"); sql.append(" ORDER BY NUM ASC");
	 * 
	 * pstmt = con.prepareStatement(sql.toString());
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * list = new ArrayList(); while (rs.next() == true) { StockBean StockBean = new
	 * StockBean(); StockBean.setNum(rs.getInt("NUM"));
	 * StockBean.setDateyy(rs.getString("DATEYY"));
	 * StockBean.setDatemm(rs.getString("DATEMM"));
	 * StockBean.setDatedd(rs.getString("DATEDD"));
	 * StockBean.setCount(rs.getInt("COUNT"));
	 * StockBean.setProduct_num(rs.getString("PRODUCT_NUM")); list.add(StockBean); }
	 * } catch (Exception e) { e.printStackTrace(); } finally { rs.close();
	 * pstmt.close(); }
	 * 
	 * return list; }
	 */

	// 글 목록 보기.
	public ArrayList<StockBean> selectArticleList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from product";
		ArrayList<StockBean> articleList = new ArrayList<StockBean>();
		StockBean product = null;
		/*
		 * int startrow=(page-1)*10; //읽기 시작할 row 번호..
		 */
		try {
			pstmt = con.prepareStatement(sql);
			/* pstmt.setInt(1, startrow); */
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new StockBean();
				/* product.setNum(rs.getInt("NUM")); */
				product.setDateyy(rs.getString("DATEYY"));
				product.setDatemm(rs.getString("DATEMM"));
				product.setDatedd(rs.getString("DATEDD"));
				product.setCount(rs.getInt("COUNT"));
				product.setProduct_num(rs.getString("PRODUCT_NUM"));
				articleList.add(product);
			}

		} catch (Exception ex) {
			System.out.println("getList 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	// 상품별 입출고 목록 보기.
	public ArrayList<StockBean> selectStockList(String num) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		 String sql = "SELECT A.SELLNUM,A.INQTY,A.OUTQTY,A.DATEYY,A.DATEMM,A.DATEDD,A.PRODUCT_NUM,B.PRODUCT_NAME,A.NUM";
		 		sql+=" FROM TB_PDSTOCK A, TB_PRODUCT B"; 
		 		sql+=" WHERE A.PRODUCT_NUM = B.PRODUCT_NUM";
		 		sql+=" AND A.PRODUCT_NUM = ?";
		 
		 		
		 		
		ArrayList<StockBean> articleList = new ArrayList<StockBean>();
		StockBean stock = null;
		/*
		 * int startrow=(page-1)*10; //읽기 시작할 row 번호..
		 */
		try {
			pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, num); 
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("#@@");
				stock = new StockBean();
				stock.setNum(rs.getInt("NUM"));
				stock.setSellnum(rs.getInt("SELLNUM"));
				stock.setIn(rs.getInt("INQTY"));
				stock.setOut(rs.getInt("OUTQTY"));
				stock.setDateyy(rs.getString("DATEYY"));
				stock.setDatemm(rs.getString("DATEMM"));
				stock.setDatedd(rs.getString("DATEDD"));
				stock.setProduct_num(rs.getString("PRODUCT_NUM"));
				stock.setProduct_name(rs.getString("PRODUCT_NAME"));
				articleList.add(stock);
			}

		} catch (Exception ex) {
			System.out.println("stockgetList 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
}
