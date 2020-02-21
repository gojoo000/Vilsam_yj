package product.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.ProductBean;

public class ProductListService {
	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		listCount = productDAO.selectListCount();
		close(con);
		return listCount;
	}

	public ArrayList<ProductBean> getArticleList() throws Exception {
		ArrayList<ProductBean> articleList = null;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		articleList = productDAO.selectArticleList();
		close(con); // return articleList;
		return articleList;
	}

}
