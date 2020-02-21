package product.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import com.oreilly.servlet.MultipartRequest;

import dao.ProductDAO;
import vo.ProductBean;

public class ProductModifyProService {

	public boolean modifyArticle(ProductBean article) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		int updateCount = productDAO.updateProduct(article);
		
		if(updateCount > 0){
			commit(con);
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}

}
