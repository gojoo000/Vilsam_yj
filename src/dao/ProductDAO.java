package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.ProductBean;

public class ProductDAO {
	DataSource ds;
	Connection con;

	private static ProductDAO insPDAO = new ProductDAO();

	private ProductDAO() {
	}//

	public static ProductDAO getInstance() {
		return insPDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 글의 개수 구하기
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println("getConnection");
			pstmt = con.prepareStatement("SELECT count(*) FROM TB_PRODUCT"); // 전체 글 갯수 구하기
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1); // 전체 글 갯수를 listCount에 할당(저장)
			}
		} catch (Exception e) {
			System.out.println("getListCount 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	// 상품 등록.
	public int insertArticle(ProductBean article) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement("select max(PRODUCT_NUM) from TB_PRODUCT");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into TB_PRODUCT (PRODUCT_NUM,PRODUCT_IMAGE,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CATEGORY)";
			sql += "values(?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getProduct_image());
			pstmt.setString(3, article.getProduct_name());
			pstmt.setInt(4, article.getProduct_price());
			pstmt.setString(5, article.getProduct_category());
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("ProductInsert 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	// 상품목록 보기.
		public ArrayList<ProductBean> selectArticleList() {

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			// String sql="select * from product"; 
			String sql = "SELECT S.PRODUCT_NUM,P.PRODUCT_IMAGE,P.PRODUCT_CATEGORY,P.PRODUCT_NAME, P.PRODUCT_PRICE";
					sql += "	,(SELECT SUM(INQTY) FROM TB_PDSTOCK WHERE S.PRODUCT_NUM) AS 'INQTY', ";
					sql += "	 (SELECT SUM(OUTQTY) FROM TB_PDSTOCK WHERE S.PRODUCT_NUM) AS 'OUTQTY' ";
					sql += "	FROM TB_PRODUCT P, TB_PDSTOCK S ";
					sql += "	WHERE P.PRODUCT_NUM=S.PRODUCT_NUM ";
					sql += "	GROUP BY P.PRODUCT_NUM";
			ArrayList<ProductBean> articleList = new ArrayList<ProductBean>();
			ProductBean product = null;
			
			 //int startrow=(page-1)*10; //읽기 시작할 row 번호..
			 
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					product = new ProductBean();
					product.setProduct_num(rs.getString("PRODUCT_NUM"));
					product.setProduct_image(rs.getString("PRODUCT_IMAGE"));
					product.setProduct_name(rs.getString("PRODUCT_NAME"));
					product.setProduct_price(rs.getInt("PRODUCT_PRICE"));
					product.setProduct_jaego((rs.getInt("INQTY") - rs.getInt("OUTQTY")));
					product.setProduct_category(rs.getString("PRODUCT_CATEGORY"));

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

	// 글 내용 보기.
	public ProductBean selectProduct(String product_num) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductBean productBean = null;
		//String sql = "select TB_PRODUCT.PRODUCT_NUM,PRODUCT_IMAGE, PRODUCT_CATEGORY,PRODUCT_NAME,PRODUCT_PRICE, SUM(INQTY) AS 'INQTY', ";
		String sql = "SELECT TB_PRODUCT.PRODUCT_NUM,PRODUCT_IMAGE, PRODUCT_CATEGORY,PRODUCT_NAME,PRODUCT_PRICE, ";
		sql += "(SELECT SUM(INQTY) FROM TB_PDSTOCK WHERE PRODUCT_NUM=?) AS 'INQTY' ,";
		sql += "(SELECT SUM(OUTQTY) FROM TB_PDSTOCK WHERE PRODUCT_NUM=?) AS 'OUTQTY' FROM TB_PRODUCT JOIN TB_PDSTOCK ";
		sql += "ON TB_PDSTOCK.PRODUCT_NUM = TB_PDSTOCK.PRODUCT_NUM WHERE TB_PRODUCT.PRODUCT_NUM =? GROUP BY TB_PRODUCT.PRODUCT_NUM";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, product_num);
			pstmt.setString(2, product_num);
			pstmt.setString(3, product_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				productBean = new ProductBean();
				productBean.setProduct_num(rs.getString("PRODUCT_NUM"));
				productBean.setProduct_image(rs.getString("PRODUCT_IMAGE"));
				productBean.setProduct_name(rs.getString("PRODUCT_NAME"));
				productBean.setProduct_jaego((rs.getInt("INQTY") - rs.getInt("OUTQTY")));
				productBean.setProduct_price(rs.getInt("PRODUCT_PRICE"));
				productBean.setProduct_category(rs.getString("PRODUCT_CATEGORY"));

			}
			System.out.println(product_num);
		} catch (Exception ex) {
			System.out.println("getDetail 에러 : " + ex);
		} finally {
			rs.close();
			pstmt.close();
		}

		return productBean;

	}

	// 상품정보 수정하기
	public int updateProduct(ProductBean article) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update TB_PRODUCT set PRODUCT_NAME=?,PRODUCT_PRICE=?,PRODUCT_CATEGORY=? where PRODUCT_NUM=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getProduct_name());
			pstmt.setInt(2, article.getProduct_price());
			pstmt.setString(3, article.getProduct_category());
			pstmt.setString(4, article.getProduct_num());
			updateCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("상품수정 Modify 에러 : " + ex);
		} finally {
			close(pstmt);
		}

		return updateCount;
	}

	// 상품삭제
	public int delProd(String PRODUCT_NUM) {
		//System.out.println(con);

		PreparedStatement pstmt = null;
		String sql = "delete from TB_PRODUCT where PRODUCT_NUM=?";
		int deleteCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, PRODUCT_NUM);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("상품Delete 에러 : " + ex);
		} finally {
			close(pstmt);
		}
		return deleteCount;

	}
}
