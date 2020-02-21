package product.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.ProductBean;

public class ProductSellService {

	public ProductBean getArticle(String product_num) {
		// TODO Auto-generated method stub
		
		ProductBean articleList = null;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		try {
			
		
		productDAO.setConnection(con);

		articleList = productDAO.selectProduct(product_num);
		}catch(Exception e){
			
		}finally {
		close(con);}
		return articleList;
		
	}

}
